package ua.goit.hw9Stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class ReadWriteFile {

    public static ArrayList<String> readFromFileToArray(String filePath) throws IOException {
        String nextLine;
        ArrayList<String> words = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((nextLine = bufferedReader.readLine()) != null) {
                String[] normalizedLines = nextLine.split("\\s+");
                for (String line: normalizedLines) {
                    words.add(line);
                }
            }
        }
        return words;
    }

    public static void printValidPhones(ArrayList<String> words) {
        for (String word: words) {
            if (word.matches("\\(d{3}\\)\\sd{3}-d{4}") || word.matches("d{3}-d{3}-d{4}")) {
                System.out.println(word);
            }
        }
    }

    /**
     *
     * @param words ArrayList of String. Elements with even indexes are keys of JSON entry.
     *              Elements with odd indexes are values of JSON entry
     */
    public static void toJson(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {

        }
    }

}
