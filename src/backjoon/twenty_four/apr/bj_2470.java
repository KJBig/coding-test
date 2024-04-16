package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int[] numbers = new int[N+1];
        String[] numberInput = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }

        int front = 0;
        int back = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        while (back <= front && front <= N) {
            if (sum >= S) {
                minSize = Math.min(minSize, front - back);
                sum -= numbers[back];
                back++;
            } else {
                sum += numbers[front];
                front++;
            }
        }

        if (minSize > N) {
            minSize = 0;
        }

        System.out.println(minSize);

    }
}
