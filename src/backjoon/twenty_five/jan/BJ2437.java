package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BJ2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        long sum = 0;
        for (int i=0; i<N; i++) {
            if (sum +1 < numbers[i]) {
                break;
            }
            sum  += numbers[i];
        }

        System.out.println(sum+1);

    }
}
