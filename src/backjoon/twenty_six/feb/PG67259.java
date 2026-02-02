package backjoon.twenty_six.feb;

import java.util.*;

public class PG67259 {
    class Solution {
        static final int INF = Integer.MAX_VALUE;

        static final int[] DY = {-1, 1, 0, 0};
        static final int[] DX = {0, 0, -1, 1};

        public int solution(int[][] board) {
            int n = board.length;

            int[][][] cost = new int[n][n][4];
            for (int y=0; y<n; y++) {
                for (int x=0; x<n; x++) {
                    Arrays.fill(cost[y][x], INF);
                }
            }

            Queue<State> queue = new ArrayDeque<>();

            for (int i=0; i<4; i++) {
                cost[0][0][i] = 0;
                queue.add(new State(0, 0, i));
            }

            while (!queue.isEmpty()) {
                State poll = queue.poll();
                int y = poll.y;
                int x = poll.x;
                int dir = poll.dir;
                int pollCost = cost[y][x][dir];

                for (int i=0; i<4; i++) {
                    int nextY = y + DY[i];
                    int nextX = x + DX[i];

                    if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                        continue;
                    }

                    if (board[nextY][nextX] == 1) {
                        continue;
                    }

                    int add = (dir == i) ? 100 : 600;
                    int nextCost = pollCost + add;

                    if (cost[nextY][nextX][i] > nextCost) {
                        cost[nextY][nextX][i] = nextCost;
                        queue.add(new State(nextY, nextX, i));
                    }
                }
            }

            int answer = INF;
            for (int i=0; i<4; i++) {
                answer = Math.min(answer, cost[n-1][n-1][i]);
            }

            return answer;
        }

        static class State {
            int y;
            int x;
            int dir;

            public State(int y, int x, int dir) {
                this.y = y;
                this.x = x;
                this.dir = dir;
            }
        }
    }

}
