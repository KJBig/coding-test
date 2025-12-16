package backjoon.twenty_five.dec;

import java.io.*;

public class BJ17136 {
    static int[][] BOARD = new int[10][10];
    static int[] PAPER = {5, 5, 5, 5, 5};
    static int ANSWER = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<10; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                BOARD[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0, 0, 0);

        if (ANSWER == Integer.MAX_VALUE) {
            ANSWER = -1;
        }

        System.out.println(ANSWER);

    }

    private static void dfs(int y, int x, int count) {
        if (y>=9 && x>9) {
            ANSWER = Math.min(ANSWER, count);
            return;
        }

        if (ANSWER <= count) {
            return;
        }

        if (x>9) {
            x = 0;
            y++;
        }

        if (BOARD[y][x] == 1) {
            for (int i=4; i>=0; i--) {
                if (PAPER[i]>0 && canAttach(y, x, i+1)) {
                    PAPER[i]--;
                    attach(y, x, i+1);
                    dfs(y, x+1, count+1);
                    detach(y, x, i+1);
                    PAPER[i]++;
                }
            }

        } else {
            dfs(y, x+1, count);
        }

    }

    private static void detach(int y, int x, int size) {
        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                BOARD[i][j] = 1;
            }
        }
    }

    private static void attach(int y, int x, int size) {
        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                BOARD[i][j] = 0;
            }
        }
    }

    private static boolean canAttach(int y, int x, int size) {
        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                if (i<0 || i>9 || j<0 || j>9) {
                    return false;
                }

                if (BOARD[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
