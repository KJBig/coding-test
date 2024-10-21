package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        Deque<Balloon> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            deque.add(new Balloon(i, Integer.parseInt(numbers[i-1])));
        }

        for (int i=0; i<N; i++) {
            Balloon balloon = deque.pollFirst();
            sb.append(balloon.number).append(" ");

            if (deque.isEmpty()){
                break;
            }

            if (balloon.value > 0) {
                shiftLeft(deque, balloon.value-1);
            } else {
                shiftRight(deque, balloon.value);
            }

        }

        System.out.println(sb);

    }

    private static void shiftLeft(Deque<Balloon> deque, int value) {
        for (int i=0; i<value; i++) {
            Balloon balloon = deque.pollFirst();
            deque.addLast(balloon);
        }
    }

    private static void shiftRight(Deque<Balloon> deque, int value) {
        value = Math.abs(value);
        for (int i=0; i<value; i++) {
            Balloon balloon = deque.pollLast();
            deque.addFirst(balloon);
        }
    }

    static class Balloon {
        public int value;
        public int number;

        public Balloon(int number, int value) {
            this.value = value;
            this.number = number;
        }
    }

}
