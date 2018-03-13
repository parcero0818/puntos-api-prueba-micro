package co.com.ath.fidelizacion.api.puntos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.ath.fidelizacion.api.puntos.domain.MensajesModel;

public interface MensajeRepositorio extends JpaRepository<MensajesModel, Long> {

    @Query(value = "SELECT * FROM TMENSAJES WHERE CODIGO_MENSAJE=?1", nativeQuery = true)
    MensajesModel findByCodMensaje(long codError);

}
