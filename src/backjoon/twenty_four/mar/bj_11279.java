package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int order = Integer.parseInt(br.readLine());

            if (order == 0) {
                Integer poll = Optional.ofNullable(priorityQueue.poll()).orElse(0);
                System.out.println(poll);
            } else {
                priorityQueue.add(order);
            }

        }


    }
}
