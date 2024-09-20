package backjoon.twenty_four.sep;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class bj_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);
        int answer = 0;

        for (int i=0; i<N; i++) {
            int start = 0;
            int end = N-1;
            while (start < end) {
                int ifNumber = numbers[start] + numbers[end];
                if(start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                if (ifNumber == numbers[i]) {
                    answer++;
                    break;
                }
                if (ifNumber < numbers[i]) {
                    start++;
                    continue;
                }
                if (ifNumber > numbers[i]) {
                    end--;
                }
            }
        }
        System.out.println(answer);

    }
}
