package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1062 {
    static int N, K, MAX_NUM = 0;
    static String[] words;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4);
        }

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(0, 5);
        System.out.println(MAX_NUM);
    }

    private static void dfs(int index, int count) {
        if (count == K) {
            countReadableWords();
            return;
        }

        for (int i = index; i < 26; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }

    private static void countReadableWords() {
        int count = 0;
        for (String word : words) {
            boolean canRead = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!visited[c - 'a']) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }
        MAX_NUM = Math.max(MAX_NUM, count);
    }
}
