package it.apuliadigital.prova_api.service.impl;

import it.apuliadigital.prova_api.model.Persona;
import it.apuliadigital.prova_api.service.PersonaService;
import it.apuliadigital.prova_api.utils.FileHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

import static it.apuliadigital.prova_api.utils.Constants.JSON_FILE_PATH;

@Service
public class PersonaServiceImpl implements PersonaService {

    private Map<Integer, Persona> personaMap = new HashMap<>();
    private int idCounter = 1;
    private FileHandler<Persona> fileHandler = new FileHandler<>(Persona.class);

    public PersonaServiceImpl() {
        caricaPersoneDaFile(); // Carica le persone dal file JSON all'avvio
    }

    @Override
    public List<Persona> getAllPersone() {
        return new ArrayList<>(personaMap.values());
    }

    @Override
    public Persona getPersonaById(int id) {
        return personaMap.get(id);
    }

    @Override
    public void addPersona(Persona persona) {
        persona.setId(idCounter++);
        personaMap.put(persona.getId(), persona);
        salvaPersoneSuFile();
    }

    @Override
    public Persona deletePersonaById(int id) {
        Persona deletedPersona = personaMap.remove(id);
        salvaPersoneSuFile();
        return deletedPersona;
    }

    private void salvaPersoneSuFile() {
        JSONArray jsonArray = new JSONArray(personaMap.values());
        fileHandler.writeJSONArrayToFile(jsonArray, JSON_FILE_PATH);
    }

    private void caricaPersoneDaFile() {
        JSONArray jsonArray = fileHandler.readJSONArrayFromFile(JSON_FILE_PATH);
        for (int i = 0; i < jsonArray.length(); i++) {
            Persona persona = fileHandler.readObjectFromFile(JSON_FILE_PATH);
            persona.setId(idCounter++);
            personaMap.put(persona.getId(), persona);
        }
    }
}