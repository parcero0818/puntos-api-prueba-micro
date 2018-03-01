package co.com.ath.fidelizacion.api.puntos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AplicacionesModel {
    @Id
    private int idApi;

    @Column(name = "NOMBRE_API", nullable = false, length = 50)
    private String nombreApi;

    public int getIdApi() {
        return idApi;
    }

    public void setIdApi(int idApi) {
        this.idApi = idApi;
    }

    public String getNombreApi() {
        return nombreApi;
    }

    public void setNombreApi(String nombreApi) {
        this.nombreApi = nombreApi;
    }

}