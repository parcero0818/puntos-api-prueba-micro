package co.com.ath.fidelizacion.api.puntos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MensajesModel {

    @Id
    private int idMensaje;

    @Column(name = "CODIGO_MENSAJE", nullable = false, length = 5)
    private long codigoMensaje;

    @Column(name = "MSJTECNICO", nullable = false, length = 500)
    private String msjTecnico;

    @Column(name = "MSJPANTALLA", nullable = false, length = 500)
    private String msjPantalla;
    
    private int id_api;

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public long getCodigoMensaje() {
        return codigoMensaje;
    }

    public void setCodigoMensaje(long codigoMensaje) {
        this.codigoMensaje = codigoMensaje;
    }

    public String getMsjTecnico() {
        return msjTecnico;
    }

    public void setMsjTecnico(String msjTecnico) {
        this.msjTecnico = msjTecnico;
    }

    public String getMsjPantalla() {
        return msjPantalla;
    }

    public void setMsjPantalla(String msjPantalla) {
        this.msjPantalla = msjPantalla;
    }

    public int getId_api() {
        return id_api;
    }

    public void setId_api(int id_api) {
        this.id_api = id_api;
    }

}
