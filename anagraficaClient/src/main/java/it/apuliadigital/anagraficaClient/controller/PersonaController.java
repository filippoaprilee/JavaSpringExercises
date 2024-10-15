package it.apuliadigital.anagraficaClient.controller;

import it.apuliadigital.anagraficaClient.client.api.PersonaApi;
import it.apuliadigital.anagraficaClient.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController implements PersonaApi {

    @Autowired
    PersonaService service;
}
