package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!input.equals(".")) {
            Stack<String> stack = new Stack<>();
            String[] strs = input.split("");
            String result = "yes";
            for (int i=0; i<strs.length; i++) {
                if (strs[i].equals("(") || strs[i].equals("[")) {
                    stack.push(strs[i]);
                }

                if (strs[i].equals(")")) {
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        result = "no";
                        break;
                    }
                }

                if (strs[i].equals("]")) {
                    if (stack.isEmpty() || !stack.pop().equals("[")) {
                        result = "no";
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                result = "no";
            }
            System.out.println(result);
            input = br.readLine();
        }

    }
}
