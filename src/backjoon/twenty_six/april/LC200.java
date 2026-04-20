package backjoon.twenty_six.april;

import java.util.*;

public class LC200 {
    class Solution {
        static int N, M;
        static char[][] BOARD;
        static boolean[][] VISITED;
        static int[] DY = {1, 0, -1, 0};
        static int[] DX = {0, 1, 0, -1};

        public int numIslands(char[][] grid) {
            int answer = 0;
            N = grid.length;
            M = grid[0].length;

            BOARD = new char[N][M];
            VISITED = new boolean[N][M];

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    BOARD[i][j] = grid[i][j];
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (BOARD[i][j] == '1' && !VISITED[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            return answer;
        }

        private void bfs(int y, int x) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{y, x});
            VISITED[y][x] = true;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int nowY = poll[0];
                int nowX = poll[1];

                for (int i=0; i<4; i++) {
                    int nextY = nowY + DY[i];
                    int nextX = nowX + DX[i];

                    if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                        continue;
                    }

                    if (BOARD[nextY][nextX] == '1' && !VISITED[nextY][nextX]) {
                        VISITED[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
