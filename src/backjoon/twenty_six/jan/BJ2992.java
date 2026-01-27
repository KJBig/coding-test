package backjoon.twenty_six.jan;

import java.io.*;

public class BJ2992 {

    static int N, NUM;
    static int min = Integer.MAX_VALUE;
    static int[] NUMBERS, LIST;
    static boolean[] VISITED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        NUM = Integer.parseInt(X);
        N = X.length();
        NUMBERS = new int[N];
        LIST = new int[N];
        VISITED = new boolean[N];

        for (int i=0; i<N; i++) {
            NUMBERS[i] = X.charAt(i) - '0';
        }

        backTracking(0);

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    static void backTracking(int depth) {
        if (depth == N) {
            StringBuilder s = new StringBuilder();
            for (int i : LIST) {
                s.append(i);
            }

            int n = Integer.parseInt(s.toString());

            if (NUM < n) {
                min = Math.min(min, n);
            }
            return;
        }

        for (int i=0; i<N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                LIST[depth] = NUMBERS[i];
                backTracking(depth + 1);
                VISITED[i] = false;
            }
        }
    }
}
