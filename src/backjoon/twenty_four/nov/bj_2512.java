package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int AMOUNT = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);
        int start = 0;
        int end = numbers[N-1];
        int MIN_REST = 0;
        int answer = 0;

        while (start <= end) {
            int now = (int) Math.round(((double)start + (double)end) / 2);

            int nowTotal = checkTotal(numbers, now);

            if (nowTotal == AMOUNT) {
                answer = now;
                break;
            }

            if (nowTotal <= AMOUNT && MIN_REST < nowTotal) {
                MIN_REST = nowTotal;
                answer = now;
            }

            if (start==now || end==now) {
                if (nowTotal <= AMOUNT) {
                    answer = now;
                }
                break;
            }

            if (nowTotal > AMOUNT) {
                end = now;
            }

            if (nowTotal < AMOUNT) {
                start = now;
            }

        }

        System.out.println(answer);

    }

    private static int checkTotal(int[] numbers, int now) {
        int total = 0;
        for (int number : numbers) {
            if (number > now) {
                total += now;
            } else {
                total += number;
            }
        }
        return total;
    }
}
