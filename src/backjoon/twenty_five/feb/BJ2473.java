package backjoon.twenty_five.feb;

import java.io.*;
import java.util.*;

public class BJ2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N];
        long answer = Long.MAX_VALUE;
        List<Long> answerNumbers = new ArrayList<>();

        String[] inputNumbers = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            numbers[i] = Long.parseLong(inputNumbers[i]);
        }

        Arrays.sort(numbers);


        for (int start=0; start<N-2; start++) {
            int mid = start+1;
            int end = N-1;
            while (mid < end) {
                long sum = numbers[start] + numbers[mid] + numbers[end];
                long absSum = Math.abs(sum);
                if (answer > absSum) {
                    answer = absSum;
                    answerNumbers = List.of(numbers[start], numbers[mid], numbers[end]);
                }

                if (sum < 0) {
                    mid++;
                } else {
                    end--;
                }
            }
        }

        for (Long answerNumber : answerNumbers) {
            System.out.print(answerNumber + " ");
        }
    }

}
