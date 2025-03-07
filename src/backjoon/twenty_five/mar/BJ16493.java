package backjoon.twenty_five.mar;

import java.io.*;

public class BJ16493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 반납까지 남은 일
        int M = Integer.parseInt(input[1]); // 챕터 수

        int[][] dp = new int[N+1][M+1];

        for (int i=1; i<=M; i++) {
            String[] data = br.readLine().split(" ");
            int date = Integer.parseInt(data[0]);
            int chapter = Integer.parseInt(data[1]);
            for (int j=1; j<=N; j++) {
                if (j<date) {
                    dp[j][i] = dp[j][i-1];
                    continue;
                }

                int subDate = j-date;
                dp[j][i] = Math.max(dp[j][i-1], chapter+dp[subDate][i-1]);

            }
        }

        System.out.println(dp[N][M]);

    }
}
