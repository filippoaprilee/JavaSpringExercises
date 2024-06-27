package it.apuliadigital.prova_api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import java.io.*;

public class FileHandler<T> {

    private final Class<T> classGenerics;
    private final ObjectMapper objectMapper;

    public FileHandler(Class<T> classGenerics) {
        this.classGenerics = classGenerics;
        this.objectMapper = new ObjectMapper();
    }

    public JSONArray readJSONArrayFromFile(String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return new JSONArray(stringBuilder.toString());
        }
    }

    public void writeJSONArrayToFile(JSONArray jsonArray, String filePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString(2)); // Indentazione per una formattazione più leggibile
        }
    }

    public T readObjectFromFile(String json) throws IOException {
        return objectMapper.readValue(json, classGenerics);
    }

//    public void writeObjectToFile(T object, String filePath) throws IOException {
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(objectMapper.writeValueAsString(object));
//        }
//    }
}