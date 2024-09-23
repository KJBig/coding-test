package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class bj_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<N; i++) {
            int now = numbers[i];
            if (!count.keySet().contains(now)) {
                count.put(now, 0);
            }
            Integer nowCount = count.get(now);
            count.put(now, nowCount+1);
        }

        List<Integer> oBigNums = new ArrayList<>();


        for (int i=N-1; i>=0; i--) {
            int oBigNum = -1;
            int now = numbers[i];
            Integer nowCount = count.get(now);
            while (!stack.isEmpty() && nowCount >= count.get(stack.peek())) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(now);
            } else {
                oBigNum = stack.peek();
                stack.push(now);
            }

            oBigNums.add(oBigNum);
            stack.push(now);
        }

        StringBuilder sb = new StringBuilder();
        Collections.reverse(oBigNums);
        for (int i=0; i<N; i++) {
            sb.append(oBigNums.get(i)).append(" ");
        }
        System.out.println(sb);
    }

}
