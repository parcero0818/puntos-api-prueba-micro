package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;

public class DisposablePointsRs implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Status status;
    protected LoyMemberPartnerInfoType loyMemberPartnerInfo;

    public Status getStatusType() {
        return status;
    }

    public void setStatusType(Status status) {
        this.status = status;
    }

    public LoyMemberPartnerInfoType getLoyMemberPartnerInfo() {
        return loyMemberPartnerInfo;
    }

    public void setLoyMemberPartnerInfo(LoyMemberPartnerInfoType loyMemberPartnerInfo) {
        this.loyMemberPartnerInfo = loyMemberPartnerInfo;
    }

}
