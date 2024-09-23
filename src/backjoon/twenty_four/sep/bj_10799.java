package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Stream;

public class bj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        int answer = 0;
        boolean before = false;

        for (int i=0; i<split.length; i++) {
            if (split[i].equals(")")) {
                stack.pop();
                if (!before) {
                    answer += stack.size();
                } else {
                    answer += 1;
                }

                before = true;
            } else {
                stack.push(split[i]);
                before = false;
            }
        }

        System.out.println(answer);
    }
}
