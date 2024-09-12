package backjoon.twenty_four.sep;

import java.io.*;
import java.util.*;

public class bj_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        PriorityQueue<Long> queue = new PriorityQueue<>();

        String[] numbers = br.readLine().split(" ");

        setQueue(N, queue, numbers);

        processGame(M, queue);

        long answer = getAnswer(queue);

        System.out.println(answer);

    }

    private static long getAnswer(PriorityQueue<Long> queue) {
        long answer = 0;
        while (!queue.isEmpty()) {
            answer += queue.poll();
        }
        return answer;
    }

    private static void processGame(int M, PriorityQueue<Long> queue) {
        for (int i = 0; i< M; i++) {
            long x = queue.poll();
            long y = queue.poll();
            long result = x + y;
            queue.add(result);
            queue.add(result);
        }
    }

    private static void setQueue(int N, PriorityQueue<Long> queue, String[] numbers) {
        for (int i = 0; i< N; i++) {
            queue.add(Long.parseLong(numbers[i]));
        }
    }
}
