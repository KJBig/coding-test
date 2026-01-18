package backjoon.twenty_six.jan;

public class PG12979 {

    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int cover = (2*w)+1;

            int start = 1;

            for (int station : stations) {
                int left = station-w;
                int gap = left-start;

                if (gap > 0) {
                    answer += (gap+cover-1) / cover;
                }

                start = station+w+1;
            }


            // 마지막 기지국
            if (start <= n) {
                int gap = n-start+1;
                answer += (gap+cover-1) / cover;
            }

            return answer;
        }
    }

}
