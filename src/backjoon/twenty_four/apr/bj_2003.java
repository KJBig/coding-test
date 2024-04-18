package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] numbers = new int[N+1];
        String[] numberInput = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }

        int start = 0;
        int end = 0;
        int sum = numbers[0];
        int count = 0;

        while (end < N) {
            if (sum < M) {
                end++;
                sum += numbers[end];
            } else if (sum == M) {
                count++;
                sum -= numbers[start];
                start++;
            } else {
                sum -= numbers[start];
                start++;
            }

        }
        System.out.println(count);
    }
}
