package co.com.ath.fidelizacion.api.puntos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RefreshScope
public class Propiedades {

    @Value("${endpoints.puntos.endopoint}")
    private String endPointLoyaltyPoints;

   

    // @Value("${loyaltyPoints}")
    // private String mensajeServicio;
    //
    // @Value("${loyaltyPoints.mensajeUsuaurio}")
    // private String mensajeUsuario;
    //
    //
    public String getEndPointLoyaltyPoints() {
        return endPointLoyaltyPoints;
    }

    public void setEndPointLoyaltyPoints(String endPointLoyaltyPoints) {
        this.endPointLoyaltyPoints = endPointLoyaltyPoints;
    }
    //
    // public String getMensajeServicio() {
    // return mensajeServicio;
    // }
    //
    // public void setMensajeServicio(String mensajeServicio) {
    // this.mensajeServicio = mensajeServicio;
    // }
    //
    // public String getMensajeUsuario() {
    // return mensajeUsuario;
    // }
    //
    // public void setMensajeUsuario(String mensajeUsuario) {
    // this.mensajeUsuario = mensajeUsuario;
    // }
    //

    public String obtenerPropiedad(String prop) {
        return null;
    }
}

