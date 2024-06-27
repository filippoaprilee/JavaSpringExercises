package it.apuliadigital.prova_api.service.impl;

import it.apuliadigital.prova_api.model.Persona;
import it.apuliadigital.prova_api.service.PersonaService;
import it.apuliadigital.prova_api.utils.FileHandler;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.*;

import static it.apuliadigital.prova_api.utils.Constants.JSON_FILE_PATH;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final Map<Integer, Persona> personaMap = new HashMap<>();
    private int idCounter = 1;

    private final FileHandler<Persona> fileHandler = new FileHandler<>(Persona.class);

    @PostConstruct
    private void init() {
        caricaPersoneDaFile();
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

    @Override
    public void deleteAll() {
        personaMap.clear();
        salvaPersoneSuFile();
    }

    private void salvaPersoneSuFile() {
        try {
            JSONArray jsonArray = new JSONArray(new ArrayList<>(personaMap.values()));
            fileHandler.writeJSONArrayToFile(jsonArray, JSON_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void caricaPersoneDaFile() {
        try {
            JSONArray jsonArray = fileHandler.readJSONArrayFromFile(JSON_FILE_PATH);
            for (int i = 0; i < jsonArray.length(); i++) {
                Persona persona = fileHandler.readObjectFromFile(jsonArray.getJSONObject(i).toString());
                if (persona != null) {
                    persona.setId(idCounter++);
                    personaMap.put(persona.getId(), persona);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}