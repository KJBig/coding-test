package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] result = new long[N + 1];

        result[0] = 0;
        if (N >= 1) {
            result[1] = 1;
        }

        for (int i=2; i<=N; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        System.out.println(result[N]);

    }
}
