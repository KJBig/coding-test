package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class bj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] order = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<String> numbers = new LinkedList<>();
        for (int i=1; i<=order[0]; i++) {
            numbers.add(String.valueOf(i));
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        while (!numbers.isEmpty()) {
            shiftNumbers(numbers, order[1]-1);
            answer.append(numbers.pollFirst()).append(", ");
        }
        answer.delete(answer.length()-2, answer.length());
        answer.append(">");
        System.out.println(answer);
    }

    private static void shiftNumbers(Deque<String> numbers, int count) {
        for (int i=0; i<count; i++) {
            String number = numbers.pollFirst();
            numbers.addLast(number);
        }
    }

    /*
    1 2 3 4 5 6 7
    1 2 4 5 6 7
     */
}
