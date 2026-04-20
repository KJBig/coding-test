package backjoon.twenty_six.april;

public class LC944 {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int answer = 0;
            char[][] words = new char[strs.length][strs[0].length()];

            for (int i=0; i<strs.length; i++) {
                String now = strs[i];
                for (int j=0; j<strs[0].length(); j++) {
                    words[i][j] = now.charAt(j);
                }
            }

            for (int i=0; i<strs[0].length(); i++) {
                for (int j=0; j<strs.length-1; j++) {
                    if (words[j][i] > words[j+1][i]) {
                        answer++;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
