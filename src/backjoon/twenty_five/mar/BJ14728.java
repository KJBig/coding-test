package backjoon.twenty_five.mar;

import java.io.*;
public class BJ14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] dp = new int[K+1][N+1];

        for (int i=1; i<=N; i++) {
            String[] data = br.readLine().split(" ");
            int time = Integer.parseInt(data[0]);
            int score = Integer.parseInt(data[1]);

            for (int j=1; j<=K; j++) {
                if (j<time) {
                    dp[j][i] = dp[j][i-1];
                    continue;
                }
                int subTime = j - time;
                dp[j][i] = Math.max(dp[j][i-1], score + dp[subTime][i-1]);
            }
        }

        System.out.println(dp[K][N]);

    }
}
