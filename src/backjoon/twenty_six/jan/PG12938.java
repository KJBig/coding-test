package backjoon.twenty_six.jan;

public class PG12938 {
    class Solution {
        public int[] solution(int n, int s) {
            int[] answer = {};
            int divide = s/n;
            int rest = s%n;

            if (divide == 0) {
                return new int[]{-1};
            }

            answer = new int[n];

            for(int i=answer.length-1; i>=0; i--){
                answer[i] = divide;
                if(rest > 0){
                    answer[i]++;
                    rest--;
                }
            }

            return answer;
        }
    }
}
