package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;
import java.util.Date;

public class PartnerMemberStatusType implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String idPartner;
    private String idMember;
    private String namePartner;
    private String memberStatus;
    private Date registrationDate;
    private String nameSegment;
    private String partnerBalance;
    private String typeSiebel;

    public String getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(String idPartner) {
        this.idPartner = idPartner;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getNamePartner() {
        return namePartner;
    }

    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getNameSegment() {
        return nameSegment;
    }

    public void setNameSegment(String nameSegment) {
        this.nameSegment = nameSegment;
    }

    public String getPartnerBalance() {
        return partnerBalance;
    }

    public void setPartnerBalance(String partnerBalance) {
        this.partnerBalance = partnerBalance;
    }

    public String getTypeSiebel() {
        return typeSiebel;
    }

    public void setTypeSiebel(String typeSiebel) {
        this.typeSiebel = typeSiebel;
    }

}
