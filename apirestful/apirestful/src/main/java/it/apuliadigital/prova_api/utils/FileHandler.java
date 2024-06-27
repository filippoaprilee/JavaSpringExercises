package it.apuliadigital.prova_api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class FileHandler<T> {

    private final Class<T> clazz;
    private final ObjectMapper objectMapper;

    public FileHandler(Class<T> clazz) {
        this.clazz = clazz;
        this.objectMapper = new ObjectMapper();
    }

    public JSONArray readJSONArrayFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return new JSONArray(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public void writeJSONArrayToFile(JSONArray jsonArray, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString(2)); // Indentazione per una formattazione più leggibile
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T readObjectFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            return jsonObjectToJavaObject(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeObjectToFile(T object, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(javaObjectToJSONObject(object).toString(2)); // Indentazione per una formattazione più leggibile
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private T jsonObjectToJavaObject(String json) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject javaObjectToJSONObject(T object) {
        try {
            return new JSONObject(objectMapper.writeValueAsString(object));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}