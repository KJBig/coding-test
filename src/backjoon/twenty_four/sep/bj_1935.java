package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class bj_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> hashMap = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("");

        for (int i=97; i<97+N; i++) {
            double number = Double.parseDouble(br.readLine());
            String alp = String.valueOf((char) Character.toUpperCase(i));
            hashMap.put(alp, number);
        }

        for (int i=0; i<split.length; i++) {
            if (split[i].equals("+")) {
                Double b = stack.pop();
                Double a = stack.pop();
                stack.push(a+b);
                continue;
            }

            if (split[i].equals("-")) {
                Double b = stack.pop();
                Double a = stack.pop();
                stack.push(a-b);
                continue;
            }

            if (split[i].equals("*")) {
                Double b = stack.pop();
                Double a = stack.pop();
                stack.push(a*b);
                continue;
            }

            if (split[i].equals("/")) {
                Double b = stack.pop();
                Double a = stack.pop();
                stack.push(a/b);
                continue;
            }

            stack.push(hashMap.get(split[i]));
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }
}
