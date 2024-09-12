package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class bj_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                queue.add(Integer.parseInt(split[j]));
            }
        }

        for (int i=0; i<N-1; i++) {
            queue.poll();
        }

        System.out.println(queue.poll());

    }

}
