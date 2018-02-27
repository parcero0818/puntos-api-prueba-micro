package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;
import java.util.Date;

public class LoyMemberPartnerInfoType implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected String custPermId;
    protected Date dateBirth;
    protected String govIssueIdentType;
    protected String govIssueIdentNum;
    protected String namePartner;
    protected String civilStatus;
    protected String gender;
    protected String idNum;
    protected String idType;
    protected String pointOfService;
    protected String custLoginId;
    private String programId;
    private String programName;
    private String programSpName;
    private Date startDt;
    protected String memberStatusCode;
    protected PartnerMemberStatusType partnerMemberStatus;

    public String getCustPermId() {
        return custPermId;
    }

    public void setCustPermId(String custPermId) {
        this.custPermId = custPermId;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGovIssueIdentType() {
        return govIssueIdentType;
    }

    public void setGovIssueIdentType(String govIssueIdentType) {
        this.govIssueIdentType = govIssueIdentType;
    }

    public String getGovIssueIdentNum() {
        return govIssueIdentNum;
    }

    public void setGovIssueIdentNum(String govIssueIdentNum) {
        this.govIssueIdentNum = govIssueIdentNum;
    }

    public String getNamePartner() {
        return namePartner;
    }

    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getPointOfService() {
        return pointOfService;
    }

    public void setPointOfService(String pointOfService) {
        this.pointOfService = pointOfService;
    }

    public String getCustLoginId() {
        return custLoginId;
    }

    public void setCustLoginId(String custLoginId) {
        this.custLoginId = custLoginId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramSpName() {
        return programSpName;
    }

    public void setProgramSpName(String programSpName) {
        this.programSpName = programSpName;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public String getMemberStatusCode() {
        return memberStatusCode;
    }

    public void setMemberStatusCode(String memberStatusCode) {
        this.memberStatusCode = memberStatusCode;
    }

    public PartnerMemberStatusType getListPartnerMemberStatus() {
        return partnerMemberStatus;
    }

    public void setPartnerMemberStatus(PartnerMemberStatusType partnerMemberStatus) {
        this.partnerMemberStatus = partnerMemberStatus;
    }

}
