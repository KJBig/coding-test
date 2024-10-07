package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_16194 {
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
                answer = Math.min(answer, dp[start] + dp[end]);
                start++;
                end--;
            }
            dp[i] = answer;
        }
        System.out.println(dp[N-1]);
    }
}

