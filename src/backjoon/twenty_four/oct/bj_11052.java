package backjoon.twenty_four.oct;

import java.io.*;
import java.util.Arrays;

public class bj_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        dp[0] = numbers[0];
        for (int i=1; i<N; i++) {
            int answer = numbers[i];
            int start = 0;
            int end = i-1;
            while (start<=end) {
                answer = Math.max(answer, dp[start] + dp[end]);
                start++;
                end--;
            }
            dp[i] = answer;
        }
        System.out.println(dp[N-1]);
    }
}

