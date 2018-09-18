package io.github.drw.rules.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reads data in from files.
 *
 * @author dr-wilkinson
 */
public class FileReader {

    private final String path;
    private final String fileName;

    /**
     * Constructs a new FileReader.
     *
     * @param path The path to the file.
     * @param fileName The name of the file.
     */
    public FileReader(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    /**
     * Reads the names.txt file in resources/names into the application.
     *
     * @return A {@link List} of {@link NameData} objects.
     */
    public List<NameData> readNameDataFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        final List<NameData> names = new ArrayList<>();
        String line;
        InputStream inputStream = classLoader.getResourceAsStream(path + "/" + fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            if (inputStream != null) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] items = line.split(" ");
                    names.add(processItems(items));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (Throwable ignore) {
                // ignore
            }
        }
        return names;
    }

    private NameData processItems(String[] items) {
        NameData.Gender gender;
        String item;
        item = items[0];
        if (item.equals("MF")) {
            gender = NameData.Gender.BOTH;
        } else if (item.equals("MO")) {
            gender = NameData.Gender.MALE;
        } else {
            gender = NameData.Gender.FEMALE;
        }
        boolean canBeLastName;
        item = items[1];
        if (item.equals("LY")) {
            canBeLastName = true;
        } else {
            canBeLastName = false;
        }
        String value = items[2].toLowerCase();
        char[] characters = value.toCharArray();
        characters[0] = Character.toUpperCase(characters[0]);
        value = String.copyValueOf(characters);
        return new NameData(value, gender, canBeLastName);
    }

}
