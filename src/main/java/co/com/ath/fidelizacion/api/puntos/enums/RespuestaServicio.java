package co.com.ath.fidelizacion.api.puntos.enums;

public enum RespuestaServicio {

    SUCCESS(0);

    private final long statusCode;

    RespuestaServicio(long statusCode) {
        this.statusCode = statusCode;
    }

    public long getStatusCode() {
        return statusCode;
    }

    
    
}
