package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        int[] counts = new int[N];
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N; i++) {
            int nowHeight = buildings[i];
            if (stack.isEmpty()){
                stack.push(new int[]{nowHeight, i, 0});
            } else {
                if (stack.peek()[0] > nowHeight) {
                    stack.push(new int[]{nowHeight, i, 0});
                } else {
                    int value = 0;
                    while (!stack.isEmpty() && stack.peek()[0] <= nowHeight) {
                        int[] pop = stack.pop();
                        counts[pop[1]] = value;
                        value += pop[2]+1;
                    }
                    stack.push(new int[]{nowHeight, i, value});
                }
            }
        }

        int value = 0;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            counts[pop[1]] = value;
            value += pop[2]+1;
        }

        long answer = 0;
        for (int count : counts) {
            answer += count;
        }

        System.out.println(answer);
    }
}
