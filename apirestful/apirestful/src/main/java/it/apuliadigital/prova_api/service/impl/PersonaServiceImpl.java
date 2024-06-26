package it.apuliadigital.prova_api.service.impl;

import it.apuliadigital.prova_api.model.Persona;
import it.apuliadigital.prova_api.service.PersonaService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonaServiceImpl implements PersonaService {
    private final String FILE_PATH = "persone.txt";
    private Map<Long, Persona> persone = new HashMap<>();

    public PersonaServiceImpl() {
        readFromFile();
    }

    @Override
    public void addPersona(Persona persona) {
        persone.put(persona.getId(), persona);
        writeToFile();
    }

    @Override
    public List<Persona> getAllPersone() {
        return new ArrayList<>(persone.values());
    }

    @Override
    public Persona getPersonaById(Long id) {
        return persone.get(id);
    }

    @Override
    public void deletePersona(Long id) {
        persone.remove(id);
        writeToFile();
    }

    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Persona persona : persone.values()) {
                writer.write(String.format("%d %s %s\n", persona.getId(), persona.getNome(), persona.getEmail()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Long id = Long.parseLong(parts[0].trim());
                String nome = parts[1].trim();
                String email = parts[2].trim();
                persone.put(id, new Persona(id, nome, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
