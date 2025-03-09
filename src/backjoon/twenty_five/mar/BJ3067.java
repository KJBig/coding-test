package backjoon.twenty_five.mar;

import java.io.*;
import java.util.stream.Stream;

public class BJ3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(br.readLine());

            int[][] dp = new int[target+1][N+1];

            for (int j=1; j<=target; j++) {
                for (int k=1; k<=N; k++) {
                    int nowCoin = coins[k-1];
                    if (j-nowCoin > 0) {
                        int subValue = j-nowCoin;
                        dp[j][k] = dp[j][k-1] + dp[subValue][k];
                    } else if (j == nowCoin) {
                        dp[j][k] = dp[j][k-1] + 1;
                    } else {
                        dp[j][k] = dp[j][k-1];
                    };
                }
            }

            System.out.println(dp[target][N]);
        }

    }
}
