package co.com.ath.fidelizacion.api.puntos.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class Propiedades {

    @Value("${endopoint.loyaltypointsadm}")
    private String endPointLoyaltyPoints;

    @Value("${loyaltyPoints.mensajeServicio}")
    private String mensajeServicio;

    @Value("${loyaltyPoints.mensajeUsuaurio}")
    private String mensajeUsuario;

    public String getEndPointLoyaltyPoints() {
        return endPointLoyaltyPoints;
    }

    public void setEndPointLoyaltyPoints(String endPointLoyaltyPoints) {
        this.endPointLoyaltyPoints = endPointLoyaltyPoints;
    }

    public String getMensajeServicio() {
        return mensajeServicio;
    }

    public void setMensajeServicio(String mensajeServicio) {
        this.mensajeServicio = mensajeServicio;
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }

}
