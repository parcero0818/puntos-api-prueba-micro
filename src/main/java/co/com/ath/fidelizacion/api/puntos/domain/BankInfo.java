package co.com.ath.fidelizacion.api.puntos.domain;

import java.io.Serializable;

public class BankInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected String bankName;
    protected String bankId;

    /**
     * Obtiene el valor de la propiedad bankIdType.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Define el valor de la propiedad bankIdType.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Obtiene el valor de la propiedad bankId.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * Define el valor de la propiedad bankId.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setBankId(String value) {
        this.bankId = value;
    }

}