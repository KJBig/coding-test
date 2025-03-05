package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int hp = 100;
        int[][] data = new int[N+1][2];
        String[] lostInput = br.readLine().split(" ");
        String[] getInput = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            data[i+1][0] = Integer.parseInt(lostInput[i]);
            data[i+1][1] = Integer.parseInt(getInput[i]);
        }

        int[][] dp = new int[hp+1][N+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=hp; j++) {
                if (j < data[i][0]) {
                    dp[j][i] = dp[j][i-1];
                    continue;
                }

                int subLost = j-data[i][0];
                dp[j][i] = Math.max(dp[j][i-1], data[i][1] + dp[subLost][i-1]);
            }
        }

        System.out.println(dp[hp-1][N]);
    }
}
