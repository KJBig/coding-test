package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class bj_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");

            if (inputs.length > 1) {
                pushInDeque(inputs, deque);
            } else {
              otherActionInDeque(inputs, deque, sb);
            }
        }

        System.out.println(sb);

    }

    private static void otherActionInDeque(String[] inputs, Deque<Integer> deque, StringBuilder sb) {
        if (inputs[0].equals("pop_front")) {
            Integer number = deque.pollFirst();
            if (number == null) {
                number = -1;
            }
            sb.append(number).append("\n");
        }

        if (inputs[0].equals("pop_back")) {
            Integer number = deque.pollLast();
            if (number == null) {
                number = -1;
            }
            sb.append(number).append("\n");
        }

        if (inputs[0].equals("size")) {
            sb.append(deque.size()).append("\n");
        }

        if (inputs[0].equals("empty")) {
            int result = 0;
            if (deque.isEmpty()) {
                result = 1;
            }
            sb.append(result).append("\n");
        }

        if (inputs[0].equals("front")) {
            Integer number = deque.peekFirst();
            if (number == null) {
                number = -1;
            }
            sb.append(number).append("\n");
        }

        if (inputs[0].equals("back")) {
            Integer number = deque.peekLast();
            if (number == null) {
                number = -1;
            }
            sb.append(number).append("\n");
        }
    }

    private static void pushInDeque(String[] inputs, Deque<Integer> deque) {
        int number = Integer.parseInt(inputs[1]);
        if (inputs[0].equals("push_back")) {
            deque.addLast(number);
        }

        if (inputs[0].equals("push_front")) {
            deque.addFirst(number);
        }
    }
}
