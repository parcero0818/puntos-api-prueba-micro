package co.com.ath.fidelizacion.api.puntos.repository;

import co.com.ath.fidelizacion.api.puntos.domain.MensajesModel;

public interface Mensajes {

    public MensajesModel findByCodMensaje(long codError);

    public Iterable<MensajesModel> findAll();

}
