package backjoon.twenty_four.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class bj_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();

        for (int i=0; i<str.length; i++) {
            String now = str[i];
            if (now.equals("<")) {
                appendWithReverse(stack, sb);
                while (!now.equals(">")) {
                    sb.append(now);
                    i++;
                    now = str[i];
                }
                sb.append(now);
            } else if (stack.isEmpty()) {
                stack.push(now);
            } else if (now.equals(" ")){
                appendWithReverse(stack, sb);
                sb.append(now);
            } else {
                stack.push(now);
            }
        }

        appendWithReverse(stack, sb);
        System.out.println(sb);

    }

    private static void appendWithReverse(Stack<String> stack, StringBuilder sb) {
        int size = stack.size();
        for (int i=0; i<size; i++) {
            sb.append(stack.pop());
        }
    }
}
