package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_9461 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            for (int j=1; j<=N; j++) {
                if (j<=3) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 2] + dp[j - 3];
                }

            }

            System.out.println(dp[N]);

        }

    }
}