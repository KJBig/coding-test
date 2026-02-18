package backjoon.twenty_six.feb;

import java.io.*;

public class BJ9663 {

    static int N;
    static int ANSWER = 0;
    static int[] ROWS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ROWS = new int[N];

        dfs(0);

        System.out.println(ANSWER);
    }

    private static void dfs(int row) {
        if (row == N) {
            ANSWER++;
            return;
        }

        for (int col=0; col<N; col++) {
            if (canLocate(row, col)) {
                ROWS[row] = col;
                dfs(row + 1);
            }
        }
    }

    private static boolean canLocate(int row, int col) {
        for (int i=0; i<row; i++) {
            if (ROWS[i] == col) {
                return false;
            }

            if (Math.abs(row-i) == Math.abs(col-ROWS[i])) {
                return false;
            }
        }
        return true;
    }
}