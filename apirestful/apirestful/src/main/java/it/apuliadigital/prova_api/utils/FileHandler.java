package it.apuliadigital.prova_api.utils;

import org.json.JSONArray;

import java.io.*;

public class FileHandler {
    public static JSONArray leggiJSONDaFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new JSONArray(); // Ritorna un array vuoto se il file non esiste
        }

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        return new JSONArray(stringBuilder.toString());
    }

    public static void scriviJSONSuFile(JSONArray jsonArray, String filePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toString(2)); // Indentazione per una formattazione più leggibile
        }
    }
}
