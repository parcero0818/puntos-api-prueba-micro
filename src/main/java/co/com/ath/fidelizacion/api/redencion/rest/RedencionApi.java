package co.com.ath.fidelizacion.api.redencion.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ath.fidelizacion.api.redencion.domain.Pais;
import co.com.ath.fidelizacion.api.redencion.domain.Response;
import co.com.ath.fidelizacion.api.redencion.repository.Redencion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Redención API", produces = "application/json")
public class RedencionApi {

    final private static Logger log = LoggerFactory.getLogger(RedencionApi.class);

    private Redencion redencion;

    @Autowired
    public RedencionApi(Redencion redencion) {
        super();
        this.redencion = redencion;
    }

    @PostMapping(value = "/restautnfilter")
    @ApiOperation(value = "restautnfilter", tags = "Redención API")
    public @ResponseBody Response restautnfilter() {
        log.info("[API - restautnfilter]");
        return new Response(200, "operacion exitosa", "{ 'mensaje': 'Filtro de Autenticación' }");
    }

    @PostMapping(value = "/restautzfilter")
    @ApiOperation(value = "restautzfilter", tags = "Redención API")
    public @ResponseBody Response restautzfilter() {
        log.info("[API - restautzfilter]");
        return new Response(200, "operacion exitosa", "{ 'mensaje': 'Filtro de Autenticación y Autorización' }");
    }

    @GetMapping(value = "/paises")
    @ApiOperation(value = "paises", tags = "Redención API")
    public @ResponseBody Iterable<Pais> listaPaises() {
        log.info("[API - paises]");
        return redencion.listaPaises();
    }
}
