package backjoon.twenty_five.oct;

import java.util.*;

public class PG42883 {

    class Solution {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);

                while (k>0 && !stack.isEmpty() && stack.peek()<c) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }

            while (k > 0) {
                stack.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder(stack.size());
            for (char ch : stack) {
                sb.append(ch);
            }

            return sb.toString();
        }
    }

}
