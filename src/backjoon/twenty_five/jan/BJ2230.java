package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        long M = Long.parseLong(split[1]);
        long[] numbers = new long[N];

        for (int i=0; i<N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(numbers);

        int start = 0;
        int end = 1;
        long minNum = Long.MAX_VALUE;
//        while (start != N-1 && end != N-1) {
        while (start<N && end<N) {
            long sub = numbers[end] - numbers[start];
            if (sub >= M) {
                if (minNum > sub) {
                    minNum = sub;
                    end++;
                } else {
                    start++;
                }
            } else {
                end++;
            }

            if (start>end) {
                end++;
            }
            if (end == N) {
                end--;
                start++;
            }
        }
        System.out.println(minNum);
    }
}
