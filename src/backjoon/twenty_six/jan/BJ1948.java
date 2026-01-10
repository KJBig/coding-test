package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        int bestLen = 0;
        int bestIdx = 0;

        for (int i=0; i<N; i++) {
            dp[i] = 1;

            for (int j=0; j<i; j++) {
                if ((numbers[j] < numbers[i]) && (dp[j]+1 > dp[i])) {
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }

            if (dp[i] > bestLen) {
                bestLen = dp[i];
                bestIdx = i;
            }
        }

        List<Integer> seq = new ArrayList<>();
        int cur = bestIdx;
        while (cur != -1) {
            seq.add(numbers[cur]);
            cur = prev[cur];
        }
        Collections.reverse(seq);

        StringBuilder sb = new StringBuilder();
        sb.append(bestLen).append('\n');
        for (int x : seq) {
            sb.append(x).append(' ');
        }
        sb.append('\n');

        System.out.print(sb);
    }
}
