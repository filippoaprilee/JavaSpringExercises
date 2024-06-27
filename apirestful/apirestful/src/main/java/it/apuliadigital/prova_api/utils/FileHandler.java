package it.apuliadigital.prova_api.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class FileHandler<T> {

    private final Class<T> clazz;

    public FileHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public JSONArray readJSONArrayFromFile(String filePath) {
        JSONArray jsonArray = new JSONArray();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            jsonArray = new JSONArray(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public void writeJSONArrayToFile(JSONArray jsonArray, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString(2)); // Indentazione per una formattazione più leggibile
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T readObjectFromFile(String filePath) {
        T object = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            object = jsonObjectToJavaObject(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public void writeObjectToFile(T object, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            JSONObject jsonObject = javaObjectToJSONObject(object);
            jsonObject.write(fileWriter); // Indentazione per una formattazione più leggibile
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private T jsonObjectToJavaObject(JSONObject jsonObject) {
        return jsonObject.toBean(clazz);
    }

    private JSONObject javaObjectToJSONObject(T object) {
        return new JSONObject(object);
    }
}