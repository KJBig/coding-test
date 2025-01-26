package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] numbers;

        for (int i=0; i<N; i++) {
            numbers = new int[10];
            String[] input = br.readLine().split(" ");
            for (int j=0; j<10; j++) {
                numbers[j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(numbers);
            sb.append(numbers[7]).append("\n");
        }
        System.out.println(sb);
    }
}
