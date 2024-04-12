package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] flow = new int[N];
        int[] dp = new int[N+1];
        for (int i=0; i<N; i++) {
            flow[i] = Integer.parseInt(br.readLine());
        }
        for (int i=1; i<=N; i++) {
            if (i == 1) {
                dp[i] = flow[0];
            } else if (i == 2) {
                dp[i] = flow[1] + flow[0];
            } else {
                dp[i] = Math.max(dp[i-2] + flow[i-1], dp[i-3] + flow[i-2] + flow[i-1]);
            }
        }
        System.out.println(dp[N]);
    }
}
