package co.com.ath.fidelizacion.redencion.domain;

import javax.persistence.Entity;

/**
 * Generic Request.
 * 
 */
@Entity
public class Pais {

    private int paId;
    private String paNombre;

    public Pais() {
       super();
    }

    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    public String getPaNombre() {
        return paNombre;
    }

    public void setPaNombre(String paNombre) {
        this.paNombre = paNombre;
    }
}
