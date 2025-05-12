package backjoon.twenty_five.may;

import java.io.*;

public class Bj1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long mod = 1000000000;
        long [] dp = new long[1000001];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i <= N; i++){
            dp[i] = (i-1)*(dp[i-2]+dp[i-1])%mod;
        }

        System.out.println(dp[N]);
    }

}
