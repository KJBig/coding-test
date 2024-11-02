package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i]=number;
        }

        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();

        for (Integer number : numbers) {
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }
}
