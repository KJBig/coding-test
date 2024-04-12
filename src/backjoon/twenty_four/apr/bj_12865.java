package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[N+1][K+1];

        for (int i=1; i<=N; i++) {
            String[] object = br.readLine().split(" ");
            int objectW = Integer.parseInt(object[0]);
            int objectV = Integer.parseInt(object[1]);

            for (int j=1; j<=K; j++) {
                if (j < objectW) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }

                int subW = j - objectW;
                dp[i][j] = Math.max(dp[i-1][j], objectV + dp[i-1][subW]);

            }

        }

        System.out.println(dp[N][K]);

    }
}
