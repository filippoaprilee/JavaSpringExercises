package it.apuliadigital.Museo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.Museo.api.OpereApi;
import it.apuliadigital.Museo.model.Opera;
import it.apuliadigital.Museo.service.OperaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperaController implements OpereApi {

    @Autowired
    private OperaService operaService;

    Logger logger = LoggerFactory.getLogger(OperaController.class);

    @Override
    public ResponseEntity<Void> aggiornaOpera(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Long idOpera,
            @Parameter(name = "Opera", description = "Dati aggiornati dell'opera", required = true) @Valid @RequestBody Opera opera
    ) {

        boolean updated = operaService.updateOpera(idOpera, opera);
        if (updated) {
            logger.info("Opera updated: " + opera);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Opera> creaOpera(
            @Parameter(name = "Opera", description = "Dati per la nuova opera", required = true) @Valid @RequestBody Opera opera
    ) {
        Opera newOpera = operaService.createOpera(opera);
        logger.info("Opera created: " + newOpera);
        return new ResponseEntity<>(newOpera, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> eliminaOpera(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Long idOpera
    ) {
        operaService.deleteOpera(idOpera);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Opera> getOperaById(
            @Parameter(name = "idOpera", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idOpera") Long idOpera
    ) {
        Opera opera = operaService.getOperaById(idOpera);
        if (opera != null) {
            return new ResponseEntity<>(opera, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Opera>> getTutteLeOpere() {
        List<Opera> opere = operaService.getAllOperas();
        return new ResponseEntity<>(opere, HttpStatus.OK);
    }
}
