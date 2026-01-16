package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ3986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i=0; i<N; i++) {
            String word = br.readLine();
            if (word.length() % 2 == 1) {
                continue;
            }
            Stack<Character> stack = new Stack<>();

            stack.push(word.charAt(0));

            for (int j=1; j<word.length(); j++) {
                char ch = word.charAt(j);

                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }

            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);

    }
}
