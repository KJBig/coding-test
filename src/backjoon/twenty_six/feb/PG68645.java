package backjoon.twenty_six.feb;

import java.util.*;

public class PG68645 {

    class Solution {

        static int Y, X, INDEX, N;
        static boolean STOP_FLAG = false;
        static int[][] TOP;

        public int[] solution(int n) {
            int[] answer = {};
            N = n;
            TOP = new int[n][n];
            Y = -1;
            X = 0;
            INDEX = 1;

            // 삼각형 채우기
            while (true) {
                fillDown();
                if (STOP_FLAG) {
                    break;
                }

                fillRight();
                if (STOP_FLAG) {
                    break;
                }

                fillUp();
                if (STOP_FLAG) {
                    break;
                }
            }

            // 정답 도출
            List<Integer> numbers = new ArrayList<>();
            for (int[] data : TOP) {
                for (int a : data) {
                    if (a == 0) {
                        break;
                    }
                    numbers.add(a);
                }
            }

            answer = new int[numbers.size()];

            for (int i=0; i<numbers.size(); i++) {
                answer[i] = numbers.get(i);
            }

            return answer;
        }

        private static void fillUp() {
            if (Y-1<0 || X-1<0) {
                STOP_FLAG = true;
                return;
            }
            if (TOP[Y-1][X-1] != 0) {
                STOP_FLAG = true;
                return;
            }

            X--;
            Y--;
            for(int i=Y; i>=0; i--) {
                if (TOP[i][X] != 0) {
                    Y++;
                    X++;
                    break;
                }
                TOP[i][X] = INDEX;
                INDEX++;
                if (Y>0) {
                    Y--;
                    X--;
                }

            }
        }

        private static void fillRight() {
            if (X+1>N-1) {
                STOP_FLAG = true;
                return;
            }
            if (TOP[Y][X+1] != 0) {
                STOP_FLAG = true;
                return;
            }

            X++;
            for(int i=X; i<N; i++) {
                if (TOP[Y][i] != 0) {
                    X--;
                    break;
                }
                TOP[Y][i] = INDEX;
                INDEX++;
                if (X<N-1) {
                    X++;
                }

            }
        }

        private static void fillDown() {
            if (Y+1>N-1) {
                STOP_FLAG = true;
                return;
            }
            if (TOP[Y+1][X] != 0) {
                STOP_FLAG = true;
                return;
            }

            Y++;
            for(int i=Y; i<N; i++) {
                if (TOP[i][X] != 0) {
                    Y--;
                    break;
                }
                TOP[i][X] = INDEX;
                INDEX++;
                if (Y<N-1) {
                    Y++;
                }
            }
        }

    }

}
