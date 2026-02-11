package backjoon.twenty_six.feb;

import java.io.*;

public class BJ1051 {
    static int N, M;
    static int[][] BOARD;
    static int MAX_SIZE = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        M = Integer.parseInt(initInput[1]);

        BOARD = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                check(i, j);
            }
        }

        System.out.println(MAX_SIZE);

    }

    private static void check(int y, int x) {
        for (int s=0; y+s<N && x+s<M; s++) {
            if (BOARD[y][x] == BOARD[y][x+s] && BOARD[y][x] == BOARD[y+s][x] && BOARD[y][x] == BOARD[y+s][x+s]) {
                int size = (s+1)*(s+1);
                MAX_SIZE = Math.max(MAX_SIZE, size);
            }
        }
    }

}
