package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1904 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];



        for (int i=1; i<=N; i++) {
            if (i==1) {
                dp[1] = 1;
            } else if (i==2){
                dp[2] = 2;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
        }

        System.out.println(dp[N]);


    }
}