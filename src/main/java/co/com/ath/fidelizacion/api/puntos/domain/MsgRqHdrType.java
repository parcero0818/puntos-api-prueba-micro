package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;
import java.util.Date;

public class MsgRqHdrType implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String channel;
    private BankInfo bankInfo;
    private Date clientDt;
    private String ipAddr;
    private boolean reverse;
    private String language;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Date getClientDt() {
        return clientDt;
    }

    public void setClientDt(Date clientDt) {
        this.clientDt = clientDt;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
