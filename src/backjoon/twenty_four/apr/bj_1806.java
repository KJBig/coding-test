package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numberInput = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }

        Arrays.sort(numbers);

        int back = 0;
        int front = N-1;

        int target = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (back < front) {
            int now = numbers[back] + numbers[front];
            if (target > Math.abs(now)) {
                target = Math.abs(now);
                result[0] = numbers[back];
                result[1] = numbers[front];
            }

            if (now > 0) {
                front--;
            } else {
                back++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
