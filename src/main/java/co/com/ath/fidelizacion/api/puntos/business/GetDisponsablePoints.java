package co.com.ath.fidelizacion.api.puntos.business;

import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRq;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRs;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.exception.TechnicalException;

/**
 * 
 * @author john.ramirez
 *
 */
public interface GetDisponsablePoints {

    /**
     * 
     * @param request
     * @return
     * @throws TechnicalException
     */
    DisposablePointsRs getDisponsablePoints(DisposablePointsRq request) throws TechnicalException;
}
