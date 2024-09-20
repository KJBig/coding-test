package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class bj_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] target = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[M];

        Arrays.sort(numbers);

        for (int i=0; i<M; i++) {
            int start = 0;
            int end = N-1;
            int now = target[i];
            while(start <= end) {
                int mid = (end+start)/2;
                if (numbers[mid] == now) {
                    answer[i] = 1;
                    break;
                }

                if (numbers[mid] > now) {
                    end = mid-1;
                    continue;
                }

                if (numbers[mid] < now) {
                    start = mid+1;
                    continue;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());

    }
}
