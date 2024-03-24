package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int cards = Integer.parseInt(br.readLine());
            priorityQueue.add(cards);
        }

        int result = 0;

        while (priorityQueue.size() > 1) {
            Integer poll1 = priorityQueue.poll();
            Integer poll2 = priorityQueue.poll();
            int plus = poll1 + poll2;
            result += plus;
            priorityQueue.add(plus);
        }

        System.out.println(result);
    }
}
