package backjoon.twenty_five.oct;

public class PG12899 {
    class Solution {
        public String solution(int n) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            int head = n;
            int rest = 0;

            while (head > 0) {
                rest = head%3;
                head = head/3;

                if (rest == 0) {
                    head--;
                    rest = 3;
                }
                sb.append(rest);
            }

            answer = convertTo124(sb.reverse().toString());

            return answer;
        }

        private String convertTo124(String str) {
            StringBuilder sb = new StringBuilder();
            for (String word : str.split("")) {
                if (word.equals("3")) {
                    sb.append("4");
                } else {
                    sb.append(word);
                }
            }
            return sb.toString();
        }
    }
}
