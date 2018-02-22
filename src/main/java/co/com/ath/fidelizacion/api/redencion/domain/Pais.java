package co.com.ath.fidelizacion.api.redencion.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Generic Request.
 * 
 */
@Entity
public class Pais {

	@Id
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
