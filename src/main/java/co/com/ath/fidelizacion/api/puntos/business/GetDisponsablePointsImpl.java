package co.com.ath.fidelizacion.api.puntos.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoaval.customers.v1.DisposablePointsRqType;
import com.grupoaval.customers.v1.DisposablePointsRsType;
import com.grupoaval.customers.v1.GetDisposablePointsRequest;
import com.grupoaval.customers.v1.GetDisposablePointsResponse;
import com.grupoaval.xsd.ifx.BankInfoType;
import com.grupoaval.xsd.ifx.CustIdType;
import com.grupoaval.xsd.ifx.GovIssueIdentType;
import com.grupoaval.xsd.ifx.ListPartnerMemberStatusType;
import com.grupoaval.xsd.ifx.LoyMemberPartnerInfoType;
import com.grupoaval.xsd.ifx.MsgRqHdrType;
import com.grupoaval.xsd.ifx.SecObjKeysType;

import co.com.ath.fidelizacion.api.puntos.domain.BankInfo;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRq;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRs;
import co.com.ath.fidelizacion.api.puntos.domain.MensajesModel;
import co.com.ath.fidelizacion.api.puntos.domain.PartnerMemberStatusType;
import co.com.ath.fidelizacion.api.puntos.domain.Status;
import co.com.ath.fidelizacion.api.puntos.enums.RespuestaServicio;
import co.com.ath.fidelizacion.api.puntos.repository.Mensajes;
import co.com.ath.fidelizacion.api.puntos.repository.Propiedades;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.LoyaltyPointsAdmClient;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.LoyaltyPointsAdmClientImpl;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.exception.TechnicalException;

@Service
public class GetDisponsablePointsImpl implements GetDisponsablePoints {

    private static LoyaltyPointsAdmClient loyaltyPointsAdm;

    private Propiedades propiedades;

    @Autowired
    private Mensajes mensajes;

    // @Autowired
    // public GetDisponsablePointsImpl(Propiedades propiedades) {
    // super();
    // this.propiedades = propiedades;
    // }

    public GetDisponsablePointsImpl(Propiedades propiedades, Mensajes codigos) {
        this.propiedades = propiedades;
        this.mensajes = codigos;
        String endpoint = propiedades.getEndPointLoyaltyPoints();
        System.out.println("Endpoint" + endpoint);
        this.loyaltyPointsAdm = new LoyaltyPointsAdmClientImpl(endpoint);
    }

    public DisposablePointsRs getDisponsablePoints(DisposablePointsRq request) {
        DisposablePointsRs response = new DisposablePointsRs();
        GetDisposablePointsResponse responseWs = null;
        Status status = new Status();
        try {
            GetDisposablePointsRequest requestWs = mapearRequestServicio(request);
            responseWs = this.loyaltyPointsAdm.getDisposablePoints(requestWs);

            if (responseWs.getDisposablePointsRs().getStatus().getStatusCode() == RespuestaServicio.SUCCESS.getStatusCode()) {
                mapearRespuestaServicio(responseWs, response);
                return response;
            } else {
                throw new TechnicalException();
            }
        } catch (TechnicalException ex) {
            if (responseWs != null) {
                /* Se consulta en base de datos el codigo devuelto pro el servicio */
                long codMsj = responseWs.getDisposablePointsRs().getStatus().getStatusCode();
                status = obtenerMensaje(codMsj);
                response.setStatusType(status);
            } else {
                status = obtenerMensaje(RespuestaServicio.ERROR_500.getStatusCode());
                response.setStatusType(status);
            }
            return response;
        }
    }

    public GetDisposablePointsRequest mapearRequestServicio(DisposablePointsRq request) {
        GetDisposablePointsRequest requestWs = null;
        if (null != request) {
            requestWs = new GetDisposablePointsRequest();

            MsgRqHdrType msgRqTypeWs = new MsgRqHdrType();
            co.com.ath.fidelizacion.api.puntos.domain.MsgRqHdrType msgRqType = request.getMsgRqType();
            if (null != msgRqType) {

                BankInfoType bankInfoWs = new BankInfoType();
                BankInfo bankInfo = msgRqType.getBankInfo();

                bankInfoWs.setName(bankInfo.getBankName());
                bankInfoWs.setBankId(bankInfo.getBankId());

                msgRqTypeWs.setChannel(msgRqType.getChannel());
                msgRqTypeWs.setBankInfo(bankInfoWs);
                msgRqTypeWs.setClientDt(null);
                msgRqTypeWs.setIPAddr(msgRqType.getIpAddr());
                msgRqTypeWs.setReverse(msgRqType.isReverse());
                msgRqTypeWs.setLanguage(msgRqType.getLanguage());

            }
            CustIdType custType = new CustIdType();
            custType.setCustPermId(request.getCustPermId());

            SecObjKeysType secKeysType = new SecObjKeysType();
            secKeysType.setSecurID(request.getSecObjKeysId());

            DisposablePointsRqType disposablePointsRq = new DisposablePointsRqType();
            disposablePointsRq.setRqUID(request.getRequestId());
            disposablePointsRq.setMsgRqHdr(msgRqTypeWs);
            disposablePointsRq.setCustId(custType);

            GovIssueIdentType govIssueIdent = new GovIssueIdentType();
            govIssueIdent.setGovIssueIdentType(request.getGoyIssueldendType());
            govIssueIdent.setIdentSerialNum(request.getIdentSeralNum());

            disposablePointsRq.setGovIssueIdent(govIssueIdent);
            ;
            disposablePointsRq.setSessKey(request.getSessKey());
            disposablePointsRq.setSecObjKeys(secKeysType);

            requestWs.setDisposablePointsRq(disposablePointsRq);
        }
        return requestWs;
    }

    public void mapearRespuestaServicio(GetDisposablePointsResponse responseWs, DisposablePointsRs response) {
        DisposablePointsRsType disponsablePoints = responseWs.getDisposablePointsRs();
        LoyMemberPartnerInfoType loyMemberInfoWs = disponsablePoints.getLoyMemberPartnerInfo().get(0);
        co.com.ath.fidelizacion.api.puntos.domain.LoyMemberPartnerInfoType loyMemberInfo = new co.com.ath.fidelizacion.api.puntos.domain.LoyMemberPartnerInfoType();

        loyMemberInfo.setCustPermId(loyMemberInfoWs.getCustPermId());
        loyMemberInfo.setDateBirth(null);
        loyMemberInfo.setGovIssueIdentType(loyMemberInfoWs.getGovIssueIdent().getGovIssueIdentType());
        loyMemberInfo.setGovIssueIdentNum(loyMemberInfoWs.getGovIssueIdent().getIdentSerialNum());
        loyMemberInfo.setNamePartner(loyMemberInfoWs.getNamePartner());
        loyMemberInfo.setCivilStatus(loyMemberInfoWs.getCivilStatus());
        loyMemberInfo.setGender(loyMemberInfoWs.getGender());
        loyMemberInfo.setIdNum(loyMemberInfoWs.getIdNum());
        loyMemberInfo.setIdType(loyMemberInfoWs.getIdType());
        loyMemberInfo.setPointOfService(loyMemberInfoWs.getPointOfService());
        loyMemberInfo.setCustLoginId(loyMemberInfoWs.getCustLoginId());
        loyMemberInfo.setProgramId(loyMemberInfoWs.getProgramInfo().getProgramId());
        loyMemberInfo.setProgramName(loyMemberInfoWs.getProgramInfo().getProgramName());
        loyMemberInfo.setProgramSpName(loyMemberInfoWs.getProgramInfo().getSPName());
        loyMemberInfo.setStartDt(null);
        loyMemberInfo.setMemberStatusCode(loyMemberInfoWs.getMemberStatusCode());

        ListPartnerMemberStatusType partherMemberWs = loyMemberInfoWs.getListPartnerMemberStatus().get(0);

        PartnerMemberStatusType partherMember = new PartnerMemberStatusType();

        partherMember.setIdPartner(partherMemberWs.getIdPartner());
        partherMember.setIdMember(partherMemberWs.getIdMember());
        partherMember.setNamePartner(partherMemberWs.getNamePartner());
        partherMember.setMemberStatus(partherMemberWs.getMemberStatus());
        partherMember.setRegistrationDate(null);
        partherMember.setNameSegment(partherMemberWs.getNameSegment());
        partherMember.setPartnerBalance(partherMemberWs.getPartnerBalance());
        partherMember.setTypeSiebel(partherMemberWs.getTypeSiebel());

        loyMemberInfo.setPartnerMemberStatus(partherMember);

        response.setLoyMemberPartnerInfo(loyMemberInfo);
    }

    public Status obtenerMensaje(long codMensaje) {
        MensajesModel mensaje = null;
        Status status = new Status();
        try {
            mensaje = mensajes.findByCodMensaje(codMensaje);
            if (null != mensaje) {
                status.setStatusCode(String.valueOf(mensaje.getCodigoMensaje()));
                status.setStatusDesc(mensaje.getMsjPantalla());
                status.setStatusDesc(mensaje.getMsjTecnico());
            } else {
                throw new Exception();
            }
            return status;
        } catch (Exception e) {
            mensaje = mensajes.findByCodMensaje(RespuestaServicio.ERROR_500.getStatusCode());
            if (null != mensaje) {
                status.setStatusCode(String.valueOf(mensaje.getCodigoMensaje()));
                status.setStatusDesc(mensaje.getMsjPantalla());
                status.setStatusDesc(mensaje.getMsjTecnico());
            }
            return status;
        }
    }
}
