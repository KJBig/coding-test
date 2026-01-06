package backjoon.twenty_six.jan;

import java.io.*;

public class BJ10844 {
    static int DIV_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[10][N];

        for (int i=0; i<=9; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<N; i++) {
            dp[0][i] = dp[1][i - 1] % DIV_VALUE;
            for (int j = 1; j <= 8; j++) {
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1] % DIV_VALUE;
            }
            dp[9][i] = dp[8][i - 1] % DIV_VALUE;
        }

        long answer = 0;
        for (int i=1; i<=9; i++) {
            answer += dp[i][N - 1] % DIV_VALUE;
        }

        System.out.println(answer % DIV_VALUE);

    }
}
