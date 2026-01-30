package backjoon.twenty_six.jan;

import java.io.*;

public class BJ1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] BOARD = new int[N][N];
        for (int i=0; i<N; i++){
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<N; j++){
                if (boardInput[j].equals("X")) {
                    BOARD[i][j] = 1;
                } else {
                    BOARD[i][j] = 0;
                }
            }
        }

        int colCount = 0;
        int rowCount = 0;

        for (int i=0; i<N; i++) {
            int spaceCount = 0;
            for (int j=0; j<N; j++) {
                if (BOARD[i][j] == 0) {
                    spaceCount++;
                } else {
                    if (spaceCount >= 2) {
                        colCount++;
                    }
                    spaceCount = 0;
                }
            }

            if (spaceCount >= 2) {
                colCount++;
            }
        }

        for (int i=0; i<N; i++) {
            int spaceCount = 0;
            for (int j=0; j<N; j++) {
                if (BOARD[j][i] == 0) {
                    spaceCount++;
                } else {
                    if (spaceCount >= 2) {
                        rowCount++;
                    }
                    spaceCount = 0;
                }
            }
            if (spaceCount >= 2) {
                rowCount++;
            }
        }

        System.out.println(colCount + " " + rowCount);
    }
}
