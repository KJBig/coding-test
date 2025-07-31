package backjoon.twenty_five.jul;

import java.io.*;
import java.util.*;

public class BJ15686 {
    static int N, M;
    static int[][] MAP;
    static List<int[]> HOUSES = new ArrayList<>();
    static List<int[]> CHICKENS = new ArrayList<>();
    static List<int[]> CHOICES = new ArrayList<>();
    static int RESULT = Integer.MAX_VALUE;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 1) {
                    HOUSES.add(new int[]{i, j});
                }
                if (MAP[i][j] == 2) {
                    CHICKENS.add(new int[]{i, j});
                }
            }
        }

        VISITED = new boolean[CHICKENS.size()];

        back(0, 0);
        System.out.println(RESULT);

    }

    static void back(int depth, int start) {
        if (depth == M) {
            int sum = 0;
            for (int[] h : HOUSES) {
                int min = Integer.MAX_VALUE;
                for (int[] c : CHOICES) {
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            RESULT = Math.min(RESULT, sum);
            return;

        }


        for (int i = start; i < CHICKENS.size(); i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                CHOICES.add(CHICKENS.get(i));
                back(depth + 1, i + 1);
                CHOICES.remove(CHOICES.size() - 1);
                VISITED[i] = false;
            }
        }
    }

}
