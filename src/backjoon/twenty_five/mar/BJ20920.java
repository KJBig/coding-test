package backjoon.twenty_five.mar;

import java.io.*;
import java.util.*;

public class BJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int size = Integer.parseInt(input[1]);

        HashMap<String, Word> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String wordInput = br.readLine();
            if (wordInput.length() < size) continue;
            words.putIfAbsent(wordInput, new Word(wordInput));
            words.get(wordInput).frequency++;
        }

        List<Word> result = new ArrayList<>(words.values());

        result.sort(Comparator
                .comparing((Word w) -> w.frequency, Comparator.reverseOrder())
                .thenComparing((Word w) -> w.name.length(), Comparator.reverseOrder())
                .thenComparing(w -> w.name));

        for (Word word : result) {
            sb.append(word.name).append("\n");
        }

        System.out.print(sb);
    }

    static class Word {
        String name;
        int frequency;

        public Word(String name) {
            this.name = name;
            this.frequency = 1;
        }
    }
}
