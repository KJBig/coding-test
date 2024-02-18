package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2775 {
    private static final int[][] BOARD = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<=14; i++){
            BOARD[0][i-1] = i;
        }

        for(int i=1; i<15; i++){
            for(int j=0; j<15; j++) {
                BOARD[i][j] += BOARD[i-1][j];
                if(j > 0){
                    BOARD[i][j] += BOARD[i][j-1];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(BOARD[k][n-1]);
        }
    }
}
