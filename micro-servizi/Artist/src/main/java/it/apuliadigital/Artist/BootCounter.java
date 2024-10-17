package it.apuliadigital.Artist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BootCounter {

    private static final String FILE_PATH = "bootCount.txt";

    public static int getBootCount() {
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                String content = Files.readString(Paths.get(FILE_PATH));
                return Integer.parseInt(content.trim());
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void incrementBootCount() {
        int bootCount = getBootCount() + 1;
        try {
            Files.writeString(Paths.get(FILE_PATH), String.valueOf(bootCount), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}