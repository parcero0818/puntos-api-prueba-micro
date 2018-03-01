package co.com.ath.fidelizacion.api.puntos.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ath.fidelizacion.api.puntos.business.GetDisponsablePoints;
import co.com.ath.fidelizacion.api.puntos.business.GetDisponsablePointsImpl;
import co.com.ath.fidelizacion.api.puntos.domain.MensajesModel;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRq;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRs;
import co.com.ath.fidelizacion.api.puntos.repository.Mensajes;
import co.com.ath.fidelizacion.api.puntos.repository.Propiedades;
import co.com.ath.fidelizacion.wsclient.loyaltypointsadm.exception.TechnicalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Redención API", produces = "application/json")
public class PuntosAPI {

    final private static Logger log = LoggerFactory.getLogger(PuntosAPI.class);
    Mensajes mensajes;

    private GetDisponsablePoints getDisponsablePoints;
    final private Propiedades propiedades;

    @Autowired
    public PuntosAPI(GetDisponsablePoints getDisponsablePoints, Propiedades propiedades, Mensajes mensajes) {
        super();
        this.getDisponsablePoints = getDisponsablePoints;
        this.propiedades = propiedades;
        this.mensajes = mensajes;
    }

    @PostMapping(value = "/disponsablePoints")
    @ApiOperation(value = "DisponsablePoints", tags = "Redencion API")
    public @ResponseBody DisposablePointsRs listaPaises(DisposablePointsRq request) throws TechnicalException {
        getDisponsablePoints = new GetDisponsablePointsImpl(propiedades, mensajes);
        DisposablePointsRs response = getDisponsablePoints.getDisponsablePoints(request);
        return response;
    }

    @PostMapping(value = "/getDisponsablePoints")
    @ApiOperation(value = "getDisponsablePoints", tags = "Redencion API")
    public @ResponseBody MensajesModel prueba() {
        return mensajes.findByCodMensaje(100);
    }

}
