package backjoon.twenty_six.feb;

import java.io.*;

public class BJ3085 {

    static int N;
    static String[][] BOARD;
    static int MAX_COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BOARD = new String[N][N];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<N; j++) {
                BOARD[i][j] = boardInput[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N-1; j++) {
                // 가로 스왑
                String temp = BOARD[i][j];
                BOARD[i][j] = BOARD[i][j+1];
                BOARD[i][j+1] = temp;

                checkMaxCount();

                // 원상복구
                temp = BOARD[i][j];
                BOARD[i][j] = BOARD[i][j+1];
                BOARD[i][j+1] = temp;

                // 세로 스왑
                temp = BOARD[j][i];
                BOARD[j][i] = BOARD[j+1][i];
                BOARD[j+1][i] = temp;

                checkMaxCount();

                // 원상복구
                temp = BOARD[j][i];
                BOARD[j][i] = BOARD[j+1][i];
                BOARD[j+1][i] = temp;

            }
        }


        System.out.println(MAX_COUNT);
    }

    private static void checkMaxCount() {
        int maxCount = 0;
        for (int i=0; i<N; i++) {
            String now = BOARD[i][0];
            int count = 1;
            for (int j=1; j<N; j++) {
                if (BOARD[i][j].equals(now)) {
                    count++;
                } else {
                    now = BOARD[i][j];
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }

            maxCount = Math.max(maxCount, count);

        }

        for (int i=0; i<N; i++) {
            String now = BOARD[0][i];
            int count = 1;
            for (int j=1; j<N; j++) {
                if (BOARD[j][i].equals(now)) {
                    count++;
                } else {
                    now = BOARD[j][i];
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        MAX_COUNT = Math.max(MAX_COUNT, maxCount);
    }
}
