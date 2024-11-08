package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        String[] numberInput = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }

        int start = 0;
        int end = N-1;
        int MIN_ABS = Integer.MAX_VALUE;

        int[] answer = new int[2];

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == 0) {
                answer[0] = numbers[start];
                answer[1] = numbers[end];
                break;
            }

            if (MIN_ABS > Math.abs(sum)) {
                MIN_ABS = Math.abs(sum);
                answer[0] = numbers[start];
                answer[1] = numbers[end];
            }

            if (sum > 0) {
                end--;
            }

            if (sum < 0) {
                start++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
