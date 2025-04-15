package backjoon.twenty_five.apr;

import java.io.*;
import java.util.*;

public class BJ3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        long[] desk = new long[N];

        for (int i=0; i<N; i++) {
            desk[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(desk);
        long start = 0;
        long end = desk[N-1] * M;
        long result = 1000000000000000000L;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i=0; i<N; i++) {
                sum += mid/desk[i];
                if (sum >= M) {
                    break;
                }
            }

            if (sum >= M) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);

    }

}
