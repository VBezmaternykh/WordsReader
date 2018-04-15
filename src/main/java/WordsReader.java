import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class WordsReader {
    public static void main(String[] args) throws IOException {
        String[] words = new String[0];
        String line;

        //Reading words from a file
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\black\\Desktop\\words.txt"));
        while ((line = file.readLine()) != null) {
            words = line.split("\\s+");
        }

        //Method of counting words
        HashMap<String, Integer> wordsStatistics = new HashMap<>();
        for (String a : words) {
            if (!wordsStatistics.containsKey(a)) {
                wordsStatistics.put(a, 0);
            }
            wordsStatistics.put(a, wordsStatistics.get(a) + 1);
        }

        // Sorting A->Z
        Arrays.sort(words);
        System.out.println("Список слов (А-Я):");
        for (String b : words)
            System.out.println(b);

        //Output of counting words
        System.out.println("Кол-во повторений каждого слова:");
        for (String someWord : wordsStatistics.keySet()) {
            System.out.println("Слово " + someWord + " содержится в списке " + wordsStatistics.get(someWord) + " раз(-а);");
        }

        //Output of max number of repeats
        HashMap.Entry<String, Integer> maxRepeats = null;
        for (HashMap.Entry<String, Integer> entry : wordsStatistics.entrySet()) {
            if (maxRepeats == null || entry.getValue().compareTo(maxRepeats.getValue()) > 0) {
                maxRepeats = entry;
            }
        }
        System.out.println("Слово с макс. кол-вом повторений в списке: " + maxRepeats);


    }
}
