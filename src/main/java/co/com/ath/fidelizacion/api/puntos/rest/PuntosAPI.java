package co.com.ath.fidelizacion.api.puntos.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ath.fidelizacion.api.puntos.business.GetDisponsablePoints;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRq;
import co.com.ath.fidelizacion.api.puntos.domain.DisposablePointsRs;
import co.com.ath.fidelizacion.wsclient.exception.TechnicalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Redención API", produces = "application/json")
public class PuntosAPI {

    final private static Logger log = LoggerFactory.getLogger(PuntosAPI.class);

    final private GetDisponsablePoints getDisponsablePoints;

    @Autowired
    public PuntosAPI(GetDisponsablePoints getDisponsablePoints) {
        super();
        this.getDisponsablePoints = getDisponsablePoints;
    }

    @PostMapping(value = "/obtenerPropiedades")
    @ApiOperation(value = "getDisponsablePoints", tags = "Redencion API")
    public @ResponseBody DisposablePointsRs listaPaises(DisposablePointsRq request) throws TechnicalException {
        DisposablePointsRs response = getDisponsablePoints.getDisponsablePoints(request);
        return response;
    }
}
