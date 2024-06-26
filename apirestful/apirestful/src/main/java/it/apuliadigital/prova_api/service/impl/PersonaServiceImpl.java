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
    private final String FILE_PATH = "users.txt";
    private Map<Long, Persona> persone = new HashMap<>();

    public PersonaServiceImpl() {
        loadUsersFromFile();
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

    private void loadUsersFromFile() {
        if (!new File(FILE_PATH).exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Long id = Long.parseLong(fields[0].trim());
                String name = fields[1].trim();
                String email = fields[2].trim();

                Persona user = new Persona();
                user.setId(id);
                user.setNome(name);
                user.setEmail(email);

                persone.put(id, user);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Persona user : persone.values()) {
                writer.write(String.format("%d, %s, %s\n", user.getId(), user.getNome(), user.getEmail()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
