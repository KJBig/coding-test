package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int answer = 0;

        for (int i=0; i<split.length; i++) {
            String now = split[i];
            if (now.equals("(") || now.equals("[")) {
                if (!stack.isEmpty() && stack.peek().chars().allMatch(Character::isDigit)) {
                    answer += Integer.parseInt(stack.pop());
                }

            } else if (now.equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    answer = 0;
                    break;
                }
                stack.pop();
                String peek = stack.peek();
                pushProcess(stack, peek, 2);
            } else if (now.equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    answer = 0;
                    break;
                }
                stack.pop();
                String peek = stack.peek();
                pushProcess(stack, peek, 3);

            } else {
                System.out.println("===push");
                stack.push(now);
            }
            printStack(stack);
        }
//        if (!stack.isEmpty()) {
//            for (String s : stack) {
//                if (answer == 0) {
//                    answer = Integer.parseInt(s);
//                } else {
//                    answer *= Integer.parseInt(s);
//                }
//            }
//        }
        System.out.println(stack.size());

        System.out.println(answer);
    }

    private static void pushProcess(Stack<String> stack, String peek, int number) {
        if (peek.chars().allMatch(Character::isDigit)) {
            String pop = stack.pop();
            stack.push(String.valueOf(Integer.parseInt(pop)*number));
        } else {
            stack.push(String.valueOf(number));
        }
    }

    private static void printStack(Stack<String> stack) {
        for (String s : stack) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
