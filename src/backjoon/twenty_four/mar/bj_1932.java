package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] numbers = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j=0; j<inputs.length; j++) {
                int number = Integer.parseInt(inputs[j]);
                numbers[i][j] = number;
            }
        }
        dp[0][0] = numbers[0][0];
        //왼쪽 끝
        for (int i=1; i<N; i++) {
            dp[i][0] = dp[i-1][0] + numbers[i][0];
        }

        //오른쪽 끝
        for (int i=1; i<N; i++) {
            dp[i][i] = dp[i-1][i-1] + numbers[i][i];
        }

        for (int i=2; i<N; i++) {
            for (int j=1; j<i; j++) {
                int number1 = dp[i-1][j-1]+numbers[i][j];
                int number2 = dp[i-1][j]+numbers[i][j];

                dp[i][j] = Math.max(number1, number2);
            }
        }

        int maxNum = dp[N-1][0];

        for (int i=1; i<N; i++) {
            maxNum = Math.max(maxNum, dp[N-1][i]);
        }
        System.out.println(maxNum);

    }
}
