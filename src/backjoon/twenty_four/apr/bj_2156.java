package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N+1];
        int[] dp = new int[N+1];

        for (int i=1; i<=N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }


        for (int i=1; i<=N; i++) {
            if (i == 1) {
                dp[1] = board[1];
            } else if (i == 2) {
                dp[2] = board[1] + board[2];
            } else {
                dp[i] = Math.max(Math.max(dp[i - 2] + board[i], dp[i - 3] + board[i - 1] + board[i]), dp[i-1]);
            }
        }

        System.out.println(dp[N]);
    }
}
