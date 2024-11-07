package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        String explosion = br.readLine();
        String lastStr = explosion.substring(explosion.length()-1, explosion.length());
        Stack<String> stack = new Stack<>();

        for (int i=0; i<str.length; i++) {
            String now = str[i];
            if (lastStr.equals(now) && stack.size() >= explosion.length()-1) {
                StringBuilder sb = new StringBuilder();
                sb.append(now);
                for (int j=0; j<explosion.length()-1; j++) {
                    sb.append(stack.pop());
                }
                String reverse = sb.reverse().toString();
                if (!reverse.equals(explosion)) {
                    String[] string = sb.toString().split("");
                    for (String s : string) {
                        stack.push(s);
                    }
                }
            } else {
                stack.push(now);
            }

        }

        printStack(stack);
    }

    private static void printStack(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (String str : stack) {
                sb.append(str);
            }
        }
        System.out.println(sb);
    }
}
