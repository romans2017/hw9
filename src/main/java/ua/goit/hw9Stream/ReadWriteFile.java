package ua.goit.hw9Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class ReadWriteFile {

    static class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static List<String> readFromFileToList(String filePath, String delimiter) throws IOException {
        String nextLine;
        List<String> words = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Scanner scanner = new Scanner(fileReader);
            scanner.useDelimiter(delimiter);
            while (scanner.hasNext()) {
                nextLine = scanner.next();
                words.add(nextLine);
            }
        }
        return words;
    }

    public static List<User> readFromFileToListObjects(String filePath) throws IOException, NumberFormatException {
        String nextLine;
        List<User> words = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Scanner scanner = new Scanner(fileReader);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (!"".equals(nextLine)) {
                    String[] splitWords = nextLine.split("\\s+");
                    words.add(new User(splitWords[0], Integer.parseInt(splitWords[1])));
                }
            }
        }
        return words;
    }

    public static void output(String toOutput, Outputs destination, String outputFileName) throws FileNotFoundException, IllegalArgumentException {
        PrintStream current = System.out;
        PrintStream printStream = null;
        if (destination == Outputs.FILE) {
            if (outputFileName == null || "".equals(outputFileName.strip())) {
                throw new IllegalArgumentException("Output file name not specified");
            }
            printStream = new PrintStream(".\\src\\main\\resources\\" + outputFileName);
            System.setOut(printStream);
        } else if (destination == Outputs.CONSOLE) {
            System.setOut(current);
        }
        System.out.print(toOutput);
        System.setOut(current);
        if (printStream != null) {
            printStream.close();
        }
    }

    public static String getValidPhones(List<String> words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.matches("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$") || word.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
                stringBuilder.append(word);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String getJson(List<User> words) throws IllegalArgumentException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(words) + "\n";
    }

    public static String getNumberRepeats(List<String> words) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" ");
            stringBuilder.append(entry.getValue().toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
