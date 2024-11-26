package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class bj_27497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Deque<String> deque = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            switch (Integer.parseInt(split[0])) {
                case 1 : { stack.push(1); deque.addLast(split[1]); break; }
                case 2 : { stack.push(2); deque.addFirst(split[1]); break; }
                case 3 : {
                    if (stack.isEmpty()) {
                        break;
                    }
                    Integer pop = stack.pop();
                    if (pop == 1) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (deque.size() == 0) {
            sb.append(0);
        } else {
            for (String s : deque) {
                sb.append(s);
            }
        }

        System.out.println(sb);
    }

}
