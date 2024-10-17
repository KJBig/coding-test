package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            deque.add(i);
        }

        String[] numberInput = br.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<M; i++) {
            numbers.add(Integer.parseInt(numberInput[i]));
        }
        int count = 0;
        for (int i=0; i<M; i++) {
            Integer now = numbers.get(0);
            int index = deque.indexOf(now);
            int iterNum = Math.abs(deque.size()-index);

            if (iterNum > index) {
                shiftLeft(deque, index);
                count+=index;
            } else {
                shiftRight(deque, iterNum);
                count+=iterNum;
            }
            deque.pollFirst();
            numbers.remove(0);
        }

        System.out.println(count);
    }

    private static void shiftLeft(LinkedList<Integer> deque, int index) {
        for (int i=0; i<index; i++) {
            Integer integer = deque.pollFirst();
            deque.addLast(integer);
        }
    }

    private static void shiftRight(LinkedList<Integer> deque, int index) {
        for (int i=0; i<index; i++) {
            Integer integer = deque.pollLast();
            deque.addFirst(integer);
        }
    }

}
