package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int now = Integer.parseInt(br.readLine());
            int[][] dp = new int[now+1][2];

            if (now >= 0) {
                dp[0][0] = 1;
            }

            if (now >= 1) {
                dp[1][1] = 1;
            }

            for (int j=2; j<=now; j++) {
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1]+ dp[j-2][1];
            }

            System.out.println(dp[now][0] + " " + dp[now][1]);
        }
    }
}
