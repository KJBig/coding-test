package backjoon.twenty_four.mar;

import java.io.*;

public class bj_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(inputs[i]);
            numbers[i] = number;
            dp[i] = number;
        }

        int maxNum = dp[0];
        for (int i=1; i<N; i++) {
            int number1 = numbers[i];
            int number2 = dp[i-1] + numbers[i];
            int number3 = numbers[i-1] + numbers[i];

            dp[i] = Math.max(number1, Math.max(number2, number3));
            maxNum = Math.max(dp[i], maxNum);
        }
        System.out.println(maxNum);
    }
}
