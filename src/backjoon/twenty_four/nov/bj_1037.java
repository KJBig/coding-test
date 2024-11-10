package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        System.out.println(numbers[0] * numbers[N-1]);
    }
}
