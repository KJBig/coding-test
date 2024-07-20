package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj_1010 {
    static int[][] BOARD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);
            BOARD = new int[M+1][M+1];
            BOARD[0][0] = 1;
            BOARD[1][0] = 1;
            BOARD[1][1] = 1;
            for (int j = 2; j <= M; j++) {
                BOARD[j][0] = 1;
                BOARD[j][j] = 1;
                for (int k = 1; k < j; k++) {
                    BOARD[j][k] = BOARD[j - 1][k - 1] + BOARD[j - 1][k];
                }
            }

            System.out.println(BOARD[M][N]);
        }
    }
}