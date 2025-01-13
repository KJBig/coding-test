package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ5568 {
    static int N, K;
    static boolean[] VISITED;
    static String[] NUMBERS;
    static List<String> ANSWERS;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        VISITED = new boolean[N];
        ANSWERS = new ArrayList<>();

        NUMBERS = new String[N];
        for (int i = 0; i < N; i++) {
            NUMBERS[i] = br.readLine();
        }

        dfs(0, "");
        System.out.println(ANSWERS.size());
    }

    static void dfs(int count, String tmp) {
        if (count == K) {
            if (!ANSWERS.contains(tmp)) {
                ANSWERS.add(tmp);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                dfs(count + 1, tmp+ NUMBERS[i]);
                VISITED[i] = false;
            }
        }
    }
}
