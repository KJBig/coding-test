package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Comparator.reverseOrder());

        String[] bookInputs = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(bookInputs[i]);
            if (number > 0) {
                positiveQueue.offer(number);
            } else {
                negativeQueue.offer(Math.abs(number));
            }
        }

        int maxValue = 0;
        if (positiveQueue.isEmpty()) {
            maxValue = negativeQueue.peek();
        } else if (negativeQueue.isEmpty()) {
            maxValue = positiveQueue.peek();
        } else {
            maxValue = Math.max(positiveQueue.peek(), negativeQueue.peek());
        }

        int answer = 0;

        while (!positiveQueue.isEmpty()) {
            int temp = positiveQueue.poll();
            for (int i=0; i < M-1; i++) {
                positiveQueue.poll();

                if (positiveQueue.isEmpty()) {
                    break;
                }
            }
            answer += temp*2;
        }

        while (!negativeQueue.isEmpty()) {
            int temp = negativeQueue.poll();
            for (int i=0; i < M-1; i++) {
                negativeQueue.poll();

                if (negativeQueue.isEmpty()) {
                    break;
                }
            }
            answer += temp*2;
        }

        answer -= maxValue;

        System.out.println(answer);
    }
}
