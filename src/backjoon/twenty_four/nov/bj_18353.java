package backjoon.twenty_four.nov;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class bj_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (numbers[i] < numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxSize = 0;
        for (int i : dp) {
            maxSize = Math.max(maxSize, i);
        }

        System.out.println(N-maxSize-1);
    }
}
