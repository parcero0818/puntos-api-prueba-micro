package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;

public class Status implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String requestId;
    protected String statusCode;
    protected String severity;
    protected String statusDesc;
    protected String serverStatusCode;
    protected String serverStatusDesc;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getServerStatusCode() {
        return serverStatusCode;
    }

    public void setServerStatusCode(String serverStatusCode) {
        this.serverStatusCode = serverStatusCode;
    }

    public String getServerStatusDesc() {
        return serverStatusDesc;
    }

    public void setServerStatusDesc(String serverStatusDesc) {
        this.serverStatusDesc = serverStatusDesc;
    }

}
