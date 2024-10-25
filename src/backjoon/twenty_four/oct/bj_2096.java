package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class bj_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][3];
        int[][] max_dp = new int[N][3];
        int[][] min_dp = new int[N][3 ];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<input.length; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i=0; i<3; i++) {
            max_dp[0][i] = board[0][i];
            min_dp[0][i] = board[0][i];
        }

        for (int i=1; i<N; i++) {
            int min00 = board[i][0] + min_dp[i - 1][0];
            int min01 = board[i][0] + min_dp[i - 1][1];
            min_dp[i][0] = Math.min(min00, min01);

            int min10 = board[i][1] + min_dp[i - 1][0];
            int min11 = board[i][1] + min_dp[i - 1][1];
            int min12 = board[i][1] + min_dp[i - 1][2];
            min_dp[i][1] = Math.min(min10, Math.min(min11, min12));

            int min20 = board[i][2] + min_dp[i - 1][1];
            int min21 = board[i][2] + min_dp[i - 1][2];
            min_dp[i][2] = Math.min(min20, min21);


            int max00 = board[i][0] + max_dp[i - 1][0];
            int max01 = board[i][0] + max_dp[i - 1][1];
            max_dp[i][0] = Math.max(max00, max01);

            int max10 = board[i][1] + max_dp[i - 1][0];
            int max11 = board[i][1] + max_dp[i - 1][1];
            int max12 = board[i][1] + max_dp[i - 1][2];
            max_dp[i][1] = Math.max(max10, Math.max(max11, max12));

            int max20 = board[i][2] + max_dp[i - 1][1];
            int max21 = board[i][2] + max_dp[i - 1][2];
            max_dp[i][2] = Math.max(max20, max21);
        }

        int totalMax = Math.max(max_dp[N-1][0], Math.max(max_dp[N-1][1], max_dp[N-1][2]));
        int totalMin = Math.min(min_dp[N-1][0], Math.min(min_dp[N-1][1], min_dp[N-1][2]));

        System.out.println(totalMax + " " + totalMin);


    }

}

