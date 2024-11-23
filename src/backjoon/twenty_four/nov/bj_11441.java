package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N+1];

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(split[i]);
            if (i != 0) {
                dp[i+1] = dp[i] + numbers[i];
            } else {
                dp[i+1] = numbers[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            sb.append(dp[end]-dp[start-1]).append("\n");
        }

        System.out.println(sb);
    }
}
