package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i=0; i<N; i++) {
            dp[i] = -1;
        }

        dp[N] = 0;

        for (int i=N; i>=1; i--) {
            if (dp[i] != -1) {

                if (i%2 == 0) {
                    int divTwo = i / 2;
                    if (dp[divTwo] == -1) {
                        dp[divTwo] = dp[i] +1;
                    } else {
                        dp[divTwo] = Math.min(dp[divTwo], dp[i] +1);
                    }

                }

                if (i%3 == 0) {
                    int divThree = i / 3;
                    if (dp[divThree] == -1) {
                        dp[divThree] = dp[i] +1;
                    } else {
                        dp[divThree] = Math.min(dp[divThree], dp[i] +1);
                    }
                }

                int minusOne = i - 1;
                if (dp[minusOne] == -1) {
                    dp[minusOne] = dp[i] +1;
                } else {
                    dp[minusOne] = Math.min(dp[minusOne], dp[i] +1);
                }

            }
        }

        System.out.println(dp[1]);

    }
}
