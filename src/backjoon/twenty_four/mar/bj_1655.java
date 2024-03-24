package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (minQueue.size() == maxQueue.size()) {
                minQueue.add(number);
            } else {
                maxQueue.add(number);
            }

            if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
                if (minQueue.peek() > maxQueue.peek()) {
                    int temp = minQueue.poll();
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(temp);
                }
            }

            sb.append(minQueue.peek()+"\n");
        }
        System.out.println(sb);

    }
}