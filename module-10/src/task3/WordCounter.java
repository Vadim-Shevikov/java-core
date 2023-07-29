package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void countAndPrintWordsInFile(String filePath) {
        Map<String, Integer> wordsMap = WordCounter.countWords(filePath);

        WordCounter.printWords(wordsMap);
    }

    private static Map<String, Integer> countWords(String filePath) {
        Map<String, Integer> wordsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");

                for (String word : words) {
                    wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return wordsMap;
    }

    private static void printWords(Map<String, Integer> wordsMap) {
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
