package backjoon.twenty_six.april;

import java.util.*;

public class PG1844 {
    class Solution {
        static int N, M;
        static int[][] BOARD;
        static int[][] DP;

        static int[] DY = {1, 0, -1, 0};
        static int[] DX = {0, 1, 0, -1};

        public int solution(int[][] maps) {
            int answer = 0;
            N = maps.length;
            M = maps[0].length;
            BOARD = new int[N][M];
            DP = new int[N][M];

            for (int i=0; i<N; i++) {
                Arrays.fill(DP[i], -1);
                for (int j=0; j<M; j++) {
                    BOARD[i][j] = maps[i][j];
                }
            }

            bfs();
            answer = DP[N-1][M-1];
            return answer;
        }

        private void bfs() {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            DP[0][0] = 1;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];

                for (int i=0; i<4; i++) {
                    int ny = y + DY[i];
                    int nx = x + DX[i];

                    if (ny<0 || N<=ny || nx<0 || M<=nx) {
                        continue;
                    }

                    if (BOARD[ny][nx] == 1) {
                        if (DP[ny][nx] == -1) {
                            DP[ny][nx] = DP[y][x] + 1;
                            queue.add(new int[]{ny, nx});
                        } else if (DP[ny][nx] > DP[y][x]+1) {
                            DP[ny][nx] = DP[y][x] + 1;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }

            }
        }
    }
}
