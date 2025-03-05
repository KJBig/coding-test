package backjoon.twenty_five.mar;

import java.io.*;

public class BJ9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testSize = Integer.parseInt(br.readLine());

        for (int t=0; t<testSize; t++) {
            int coinSize = Integer.parseInt(br.readLine());
            String[] coinInput = br.readLine().split(" ");
            int[] coins = getCoins(coinInput);
            int target = Integer.parseInt(br.readLine());
            int[][] dp = new int[target+1][coinSize+1];

            for (int item=1; item<=coinSize; item++) {
                int nowCoin = coins[item-1];
                for (int value=1; value<=target; value++) {
                    if (value-nowCoin > 0) {
                        int subValue = value-nowCoin;
                        dp[value][item] = dp[value][item-1] + dp[subValue][item];
                    } else if (value == nowCoin) {
                        dp[value][item] = dp[value][item-1] + 1;
                    } else {
                        dp[value][item] = dp[value][item-1];
                    }
                }
            }

            sb.append(dp[target][coinSize]).append("\n");

        }

        System.out.println(sb);
    }

    private static int[] getCoins(String[] coinInput) {
        int[] coins = new int[coinInput.length];
        for (int i=0; i<coinInput.length; i++) {
            coins[i] = Integer.parseInt(coinInput[i]);
        }
        return coins;
    }
}
