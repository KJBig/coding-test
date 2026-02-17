package backjoon.twenty_six.feb;

import java.io.*;

public class BJ14500 {

    static int N, M;
    static int[][] BOARD;
    static boolean[][] VISITED;
    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};
    static int[][] MOUNTAIN_Y = {{0, -1, 0},{-1, 0, 1}, {0, 1, 0}, {1, 0, -1}};
    static int[][] MOUNTAIN_X = {{-1, 0, 1},{0, 1, 0}, {1, 0, -1}, {0, -1, 0}};
    static int MAX_VALUE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boardInput = br.readLine().split(" ");

        N = Integer.parseInt(boardInput[0]);
        M = Integer.parseInt(boardInput[1]);

        BOARD = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String[] scoreInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(scoreInput[j]);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                VISITED[i][j] = true;
                checkMountain(i, j, BOARD[i][j]);
                dfs(i, j, BOARD[i][j], 1);
                VISITED[i][j] = false;
            }
        }

        System.out.println(MAX_VALUE);
    }

    private static void dfs(int y, int x, int score, int count) {
        if (count == 4) {
            MAX_VALUE = Math.max(MAX_VALUE, score);
            return;
        }

        for (int i=0; i<4; i++) {
            int nextY = y + DY[i];
            int nextX = x + DX[i];

            if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                continue;
            }

            if (!VISITED[nextY][nextX]) {
                VISITED[nextY][nextX] = true;
                dfs(nextY, nextX, score+BOARD[nextY][nextX], count+1);
                VISITED[nextY][nextX] = false;
            }
        }
    }

    private static void checkMountain(int y, int x, int score) {
        for (int i=0; i<4; i++) {
            int value = score;
            for (int j=0; j<3; j++) {
                int nextY = y + MOUNTAIN_Y[i][j];
                int nextX = x + MOUNTAIN_X[i][j];

                if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                    break;
                }

                value += BOARD[nextY][nextX];
            }

            MAX_VALUE = Math.max(MAX_VALUE, value);
        }
    }
}
