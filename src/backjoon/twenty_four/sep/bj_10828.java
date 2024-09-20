package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class bj_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push": stack.push(Integer.parseInt(input[1])); break;
                case "pop": System.out.println(popStack(stack)); break;
                case "size": System.out.println(stack.size()); break;
                case "empty": System.out.println(stackEmptyCheck(stack)); break;
                case "top": System.out.println(getStackTop(stack)); break;
            }
        }

    }

    private static int popStack(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.pop();
    }

    private static int getStackTop(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    private static int stackEmptyCheck(Stack<Integer> stack) {
        int answer = 0;
        if (stack.isEmpty()) {
            answer = 1;
        }
        return answer;
    }
}
