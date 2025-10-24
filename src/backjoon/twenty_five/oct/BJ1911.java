package backjoon.twenty_five.oct;

import java.io.*;
import java.util.*;

public class BJ1911 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long L = Long.parseLong(input[1]);

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int i=0; i<N; i++) {
            String[] se = br.readLine().split(" ");
            long start = Long.parseLong(se[0]);
            long end = Long.parseLong(se[1]);
            queue.add(new long[]{start, end});
        }

        long covered = 0;
        long answer = 0;

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            long start = poll[0];
            long end = poll[1];

            long areaStart = Math.max(start, covered);
            if (areaStart >= end) {
                continue;
            }

            long len = end - areaStart;
            long need = len / L;
            if (len%L != 0) {
                need++;
            }

            answer += need;
            covered = areaStart+need*L;
        }

        System.out.println(answer);
    }
}


