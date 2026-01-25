package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ17182 {
    static int N, K;
    static int[][] DIST;
    static boolean[] VISITED;
    static int ANSWER = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        K = Integer.parseInt(initInput[1]);

        DIST = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                DIST[i][j] = Integer.parseInt(data[j]);
            }
        }

        for (int m=0; m<N; m++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (DIST[i][j] > DIST[i][m]+DIST[m][j]) {
                        DIST[i][j] = DIST[i][m]+DIST[m][j];
                    }
                }
            }
        }

        VISITED = new boolean[N];
        VISITED[K] = true;
        dfs(K, 1, 0);

        System.out.println(ANSWER);
    }

    static void dfs(int cur, int count, int sum) {
        if (sum >= ANSWER) {
            return;
        }

        if (count == N) {
            ANSWER = Math.min(ANSWER, sum);
            return;
        }

        for (int i=0; i<N; i++) {
            if (VISITED[i]) continue;

            VISITED[i] = true;
            dfs(i, count + 1, sum + DIST[cur][i]);
            VISITED[i] = false;
        }
    }
}
