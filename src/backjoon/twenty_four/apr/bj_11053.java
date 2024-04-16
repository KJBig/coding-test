package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] board = new int[N];
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            board[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (board[j] < board[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int l : dp) {
            if (max < l) {
                max = l;
            }
        }

        System.out.println(max);

    }
}
