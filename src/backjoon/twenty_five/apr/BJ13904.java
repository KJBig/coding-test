package backjoon.twenty_five.apr;

import java.io.*;
import java.util.*;

public class BJ13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0])
                .thenComparing((int[] a) -> a[1], Comparator.reverseOrder()));
        PriorityQueue<Integer> values = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            int d = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            queue.add(new int[]{d, w});
        }

        int date = 1;
        int sum = 0;


        for (int i=0; i<N; i++) {
            int[] poll = queue.poll();
            if (date <= poll[0]) {
                sum += poll[1];
                values.add(poll[1]);
                date++;
            } else {
                if (values.peek() < poll[1]) {
                    Integer vPoll = values.poll();
                    sum -= vPoll;
                    sum += poll[1];
                    values.add(poll[1]);
                }
            }
        }

        System.out.println(sum);
    }
}
