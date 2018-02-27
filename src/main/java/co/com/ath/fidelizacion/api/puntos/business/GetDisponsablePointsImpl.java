package co.com.ath.fidelizacion.api.puntos.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoaval.customers.v1.DisposablePointsRqType;
import com.grupoaval.customers.v1.DisposablePointsRsType;
import com.grupoaval.customers.v1.GetDisposablePointsRequest;
import com.grupoaval.customers.v1.GetDisposablePointsResponse;
import com.grupoaval.xsd.ifx.BankInfoType;
import com.grupoaval.xsd.ifx.CustIdType;
import com.grupoaval.xsd.ifx.ListPartnerMemberStatusType;
import com.grupoaval.xsd.ifx.LoyMemberPartnerInfoType;
import com.grupoaval.xsd.ifx.MsgRqHdrType;
import com.grupoaval.xsd.ifx.SecObjKeysType;

import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRq;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRs;
import co.com.ath.fidelizacion.api.puntos.domain.PartnerMemberStatusType;
import co.com.ath.fidelizacion.api.puntos.domain.Status;
import co.com.ath.fidelizacion.api.puntos.enums.RespuestaServicio;
import co.com.ath.fidelizacion.api.puntos.repository.Propiedades;
import co.com.ath.fidelizacion.wsclient.exception.TechnicalException;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.LoyaltyPointsAdmClient;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.LoyaltyPointsAdmClientImpl;

@Service
public class GetDisponsablePointsImpl implements GetDisponsablePoints {

    private static LoyaltyPointsAdmClient loyaltyPointsAdm;

    Propiedades propiedades;

    @Autowired
    public GetDisponsablePointsImpl(Propiedades propiedades) {
        super();
        this.propiedades = propiedades;
    }

    public GetDisponsablePointsImpl() {
        String endpoint = this.propiedades.getEndPointLoyaltyPoints();
        this.loyaltyPointsAdm = new LoyaltyPointsAdmClientImpl(endpoint);
    }

    public DisposablePointsRs getDisponsablePoints(DisposablePointsRq request) throws TechnicalException {
        try {
            GetDisposablePointsRequest requestWs = mapearRequestServicio(request);
            ;

            GetDisposablePointsResponse responseWs = this.loyaltyPointsAdm.getDisposablePoints(requestWs);

            if (responseWs.getDisposablePointsRs().getStatus().getStatusCode() == RespuestaServicio.SUCCESS.getStatusCode()) {
                DisposablePointsRs response = mapearRespuestaServicio(responseWs);
                return response;
            } else {
                throw new TechnicalException();
            }
        } catch (TechnicalException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public GetDisposablePointsRequest mapearRequestServicio(DisposablePointsRq request) {
        GetDisposablePointsRequest requestWs = new GetDisposablePointsRequest();

        BankInfoType bankInfo = new BankInfoType();
        bankInfo.setName(request.getMsgRqType().getBankInfo().getBankName());
        bankInfo.setBankId(request.getMsgRqType().getBankInfo().getBankId());

        MsgRqHdrType msgRqTypeWs = new MsgRqHdrType();
        co.com.ath.fidelizacion.api.puntos.domain.MsgRqHdrType msgRqType = request.getMsgRqType();

        msgRqTypeWs.setChannel(msgRqType.getChannel());
        msgRqTypeWs.setBankInfo(bankInfo);
        msgRqTypeWs.setClientDt(null);
        msgRqTypeWs.setIPAddr(msgRqType.getIpAddr());
        msgRqTypeWs.setReverse(msgRqType.isReverse());
        msgRqTypeWs.setLanguage(msgRqType.getLanguage());

        CustIdType custType = new CustIdType();
        custType.setCustPermId(request.getCustPermId());

        SecObjKeysType secKeysType = new SecObjKeysType();
        secKeysType.setSecurID(request.getSecObjKeysId());

        DisposablePointsRqType disposablePointsRq = new DisposablePointsRqType();
        disposablePointsRq.setRqUID(request.getRequestId());
        disposablePointsRq.setMsgRqHdr(msgRqTypeWs);
        disposablePointsRq.setCustId(custType);
        disposablePointsRq.getGovIssueIdent().setGovIssueIdentType(request.getGoyIssueldendType());
        disposablePointsRq.getGovIssueIdent().setIdentSerialNum(request.getIdentSeralNum());
        disposablePointsRq.setSessKey(request.getSessKey());
        disposablePointsRq.setSecObjKeys(secKeysType);

        requestWs.setDisposablePointsRq(disposablePointsRq);

        return requestWs;
    }

    public DisposablePointsRs mapearRespuestaServicio(GetDisposablePointsResponse responseWs) {
        DisposablePointsRs response = new DisposablePointsRs();
        Status status = new Status();
        status.setStatusCode(RespuestaServicio.SUCCESS.toString());
        status.setStatusDesc(propiedades.getMensajeUsuario());
        status.setServerStatusDesc(propiedades.getMensajeServicio());

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

        response.setStatusType(status);

        return response;

    }
}
