package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;


public class DisposablePointsRq implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String requestId;
    private MsgRqHdrType msgRqType;
    private String custPermId;
    private String goyIssueldendType;
    private String identSeralNum;
    private String sessKey;
    private String secObjKeysId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public MsgRqHdrType getMsgRqType() {
        return msgRqType;
    }

    public void setMsgRqType(MsgRqHdrType msgRqType) {
        this.msgRqType = msgRqType;
    }

    public String getCustPermId() {
        return custPermId;
    }

    public void setCustPermId(String custPermId) {
        this.custPermId = custPermId;
    }

    public String getGoyIssueldendType() {
        return goyIssueldendType;
    }

    public void setGoyIssueldendType(String goyIssueldendType) {
        this.goyIssueldendType = goyIssueldendType;
    }

    public String getIdentSeralNum() {
        return identSeralNum;
    }

    public void setIdentSeralNum(String identSeralNum) {
        this.identSeralNum = identSeralNum;
    }

    public String getSessKey() {
        return sessKey;
    }

    public void setSessKey(String sessKey) {
        this.sessKey = sessKey;
    }

    public String getSecObjKeysId() {
        return secObjKeysId;
    }

    public void setSecObjKeysId(String secObjKeysId) {
        this.secObjKeysId = secObjKeysId;
    }

}
