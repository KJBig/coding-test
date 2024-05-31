package backjoon.twenty_four.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class bj_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        int answer = 0;
        for (int number : stack) {
            answer += number;
        }

        System.out.println(answer);

    }
}
