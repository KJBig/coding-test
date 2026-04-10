package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] heights = br.readLine().split(" ");

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=N; i++) {
            int height = Integer.parseInt(heights[i-1]);

            while (!stack.isEmpty()) {
                if (stack.peek()[1] > height) {
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0").append(" ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }

            stack.push(new int[]{i, height});
        }

        System.out.println(sb.toString().trim());
    }
}