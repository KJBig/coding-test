package backjoon.twenty_five.nov;

import java.util.*;

public class PG169199 {
    class Solution {

        static int[] DY = {1, 0, -1, 0};
        static int[] DX = {0, 1, 0, -1};
        static boolean[][] VISITED;
        static int[][] NUMBER_BOARD;
        static int startY, startX, MAX_Y, MAX_X;
        static int MIN_MOVE = Integer.MAX_VALUE;

        public int solution(String[] board) {
            int answer = -1;
            NUMBER_BOARD = new int[board.length][board[0].length()];
            VISITED = new boolean[board.length][board[0].length()];
            MAX_Y = board.length;
            MAX_X = board[0].length();

            for (int i = 0; i < board.length; i++) {
                String[] now = board[i].split("");
                for (int j = 0; j < now.length; j++) {
                    if (now[j].equals("D")) {
                        NUMBER_BOARD[i][j] = -1;
                    }
                    if (now[j].equals("R")) {
                        startY = i;
                        startX = j;
                    }
                    if (now[j].equals("G")) {
                        NUMBER_BOARD[i][j] = 2;
                    }
                }
            }

            process();

            if (MIN_MOVE != Integer.MAX_VALUE) {
                answer = MIN_MOVE;
            }

            return answer;
        }

        private static void process() {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startY, startX, 0});
            VISITED[startY][startX] = true;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];
                int count = poll[2];
                if (canGo(y, x) && NUMBER_BOARD[y][x] == 2) {
                    MIN_MOVE = Math.min(MIN_MOVE, count);
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = y;
                    int nx = x;
                    while (canGo(ny + DY[i], nx + DX[i])) {
                        ny += DY[i];
                        nx += DX[i];
                    }
                    if (ny != y || nx != x) {
                        if (!VISITED[ny][nx]) {
                            VISITED[ny][nx] = true;
                            queue.add(new int[]{ny, nx, count + 1});
                        }
                    }
                }

            }
        }

        private static boolean canGo(int ny, int nx) {
            if (0 <= ny && ny < MAX_Y && 0 <= nx && nx < MAX_X) {
                if (NUMBER_BOARD[ny][nx] != -1) {
                    return true;
                }
            }
            return false;
        }
    }
}