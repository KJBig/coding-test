package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class bj_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] ids = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = 0;

        int min = Integer.MAX_VALUE;
        int count = getElement(ids, start, end);

        while (true) {
           if (count==K) {
               min = Math.min(min, end-start+1);
               start++;
               if (ids[start-1] == 1) {
                   count--;
               }
           } else {
               end++;
               if (end >= N) {
                   break;
               }
               if (ids[end] == 1) {
                 count++;
               }
           }


        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }

    private static int getElement(int[] ids, int start, int end) {
        int count = 0;
        for (int i=start; i<=end; i++) {
            if (ids[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
