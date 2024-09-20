package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class bj_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] orders = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = orders[0];
        int M = orders[1];
        int[] dp = new int[N];
        dp[0] = numbers[0];
        for (int i=1; i<N; i++) {
            dp[i] = dp[i-1] + numbers[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            int[] panel = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = 0;
            if (panel[0]-1 > 0) {
                start = dp[panel[0]-2];
            }

            sb.append(dp[panel[1]-1] - start).append("\n");
        }

        System.out.println(sb.toString());

    }
}
