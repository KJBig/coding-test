package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int totalTime = Integer.parseInt(input[0]);
        int problemSize = Integer.parseInt(input[1]);
        int[][] dp = new int[totalTime+1][problemSize+1];

        for (int i=1; i<=problemSize; i++) {
            String[] problemInput = br.readLine().split(" ");
            int value = Integer.parseInt(problemInput[0]);
            int time = Integer.parseInt(problemInput[1]);

            for (int j=1; j<=totalTime; j++) {

                if (j < time) {
                    dp[j][i] = dp[j][i-1];
                    continue;
                }

                int subTime = j-time;
                dp[j][i] = Math.max(dp[j][i-1], value + dp[subTime][i-1]);

            }
        }

        System.out.println(dp[totalTime][problemSize]);

    }
}
