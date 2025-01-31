package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = N-1;
        int maxValue = Integer.MIN_VALUE;

        while (start<=end) {
            int nowValue = getValue(numbers, start, end);
            maxValue = Math.max(nowValue, maxValue);
            if (numbers[start] < numbers[end]) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(maxValue);


    }

    private static int getValue(int[] numbers, int start, int end) {
        int value = end-start-1;
        return value*Math.min(numbers[start], numbers[end]);
    }
}
