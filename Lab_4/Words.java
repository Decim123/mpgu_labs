package Lab_4;

import java.util.ArrayList;
import java.util.List;

public class Words {
    public static List<String> findWords(String input) {
        List<String> result = new ArrayList<>();
        String[] words = input.split("\\s+");

        for (String word : words) {
            if (word.matches(".*[\\d\\p{Punct}].*")) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "TEST test! Test: 123, TesT.";
        List<String> words = findWords(input);
        System.out.println(words); // Выводит слова с цифрами или пунктуацией
    }
}
