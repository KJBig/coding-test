package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                Integer poll = priorityQueue.poll();
                if (poll == null) {
                    poll = 0;
                }
                System.out.println(poll);
            } else {
                priorityQueue.add(order);
            }
        }


    }
}
