package co.com.ath.fidelizacion.api.puntos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ath.fidelizacion.api.puntos.domain.MensajesModel;

@Service
public class MensajesImpl implements Mensajes {
    @Autowired
    MensajeRepositorio repositorio;

    public Iterable<MensajesModel> findAll() {
        return repositorio.findAll();
    }

    @Override
    public MensajesModel findByCodMensaje(long codMensaje) {
        
        return repositorio.findByCodMensaje(codMensaje);
    }
}