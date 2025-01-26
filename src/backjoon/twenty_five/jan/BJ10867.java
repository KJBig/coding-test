package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BJ10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();

        Arrays.sort(numbers);
        sb.append(numbers[0]).append(" ");
        int before = numbers[0];
        for (int i=1; i<N; i++) {
            if (numbers[i] != before) {
                sb.append(numbers[i]).append(" ");
                before = numbers[i];
            }
        }

        System.out.println(sb);
    }
}
