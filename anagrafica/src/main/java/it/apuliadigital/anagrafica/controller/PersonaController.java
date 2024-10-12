package it.apuliadigital.anagrafica.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.anagrafica.api.ApiUtil;
import it.apuliadigital.anagrafica.api.PersonaApi;
import it.apuliadigital.anagrafica.model.PersonaDTO;
import it.apuliadigital.anagrafica.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class PersonaController implements PersonaApi {

    @Autowired
    private PersonaService personaService;

    Logger logger = Logger.getLogger(PersonaController.class.getName());

    @Override
    public ResponseEntity<PersonaDTO> creaPersona(
            @Parameter(name = "PersonaDTO", description = "", required = true) @Valid @RequestBody PersonaDTO personaDTO
    ) {
        PersonaDTO newPersona = personaService.createPersona(personaDTO);
        logger.info("Persona creata: " + newPersona);
        return new ResponseEntity<PersonaDTO>(newPersona, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PersonaDTO> eliminaPersona(
            @Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica
    ) {
        personaService.deletePersona(idAnagrafica);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonaDTO>> listaPersone(

    ) {
        List<PersonaDTO> persone = personaService.getAllPersone();
        return new ResponseEntity<List<PersonaDTO>>(persone, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonaDTO> modificaPersona(
            @Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica,
            @Parameter(name = "PersonaDTO", description = "", required = true) @Valid @RequestBody PersonaDTO personaDTO
    ) {
        boolean updated = personaService.updatePersona(idAnagrafica, personaDTO);
        if (updated) {
            return new ResponseEntity<PersonaDTO>(personaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<PersonaDTO> persona(
            @Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica
    ) {
        PersonaDTO persona = personaService.getPersonaById(idAnagrafica);
        return new ResponseEntity<PersonaDTO>(persona, HttpStatus.OK);
    }
}
