package it.apuliadigital.prova_api.service.impl;

import it.apuliadigital.prova_api.model.Persona;
import it.apuliadigital.prova_api.service.PersonaService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class PersonaServiceImpl implements PersonaService {

    private static final String JSON_FILE_PATH = "persone.json";
    private Map<Integer, Persona> personaMap = new HashMap<>();
    private int idCounter = 1;

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
    public void deletePersonaById(int id) {
        personaMap.remove(id);
        salvaPersoneSuFile();
    }

    private void salvaPersoneSuFile() {
        JSONArray jsonArray = new JSONArray(personaMap.values());
        try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
            fileWriter.write(jsonArray.toString(2)); // Indentazione per una formattazione più leggibile
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void caricaPersoneDaFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_FILE_PATH))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                try {
                    Persona persona = new Persona(jsonObject);
                    persona.setId(idCounter++);
                    personaMap.put(persona.getId(), persona);
                } catch (Exception e) {
                    System.err.println("Errore nella lettura del JSON per la persona #" + i + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}