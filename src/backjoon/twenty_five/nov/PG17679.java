package backjoon.twenty_five.nov;

/*
1. 탐색
2. 빈칸 매꾸기
3. 탐색되는 애가 없으면 종료
*/

import java.util.*;

public class PG17679 {
    class Solution {

        static int[][] DY = {{0, -1, -1}, {0, -1, -1}, {1, 1, 0}, {1, 1, 0}};
        static int[][] DX = {{1, 1, 0}, {-1, -1, 0}, {0, 1, 1}, {0, -1, -1}};
        static String[][] BOARD;
        static boolean[][] VISITED;

        public int solution(int m, int n, String[] board) {
            int answer = 0;

            BOARD = new String[m][n];
            VISITED = new boolean[m][n];
            for (int i=0; i<m; i++) {
                String[] members = board[i].split("");
                for (int j=0; j<n; j++) {
                    BOARD[i][j] = members[j];
                }
            }

            int deleteCount = Integer.MAX_VALUE;
            while (deleteCount > 0) {
                deleteCount = 0;
                for (int i=0; i<m; i++) {
                    for (int j=0; j<n; j++) {
                        if (!VISITED[i][j] && !BOARD[i][j].equals("-")) {
                            int count = bfs(i, j, m, n);
                            deleteCount += count;
                        }
                    }
                }
                answer += deleteCount;
                downItem(m, n);
            }
            return answer;
        }

        private void downItem(int m, int n) {
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (VISITED[i][j]) {
                        BOARD[i][j] = "-";
                    }
                }
            }

            for (int i=m-2; i>=0; i--) {
                for (int j=0; j<n; j++) {
                    if (!BOARD[i][j].equals("-") && BOARD[i+1][j].equals("-")) {
                        int nowY = i;
                        while(nowY!=m-1) {
                            if (!BOARD[nowY+1][j].equals("-")) {
                                break;
                            }
                            BOARD[nowY+1][j] = BOARD[nowY][j];
                            BOARD[nowY][j] = "-";
                            nowY++;
                        }
                    }
                }
            }

            VISITED = new boolean[m][n];
        }

        private int bfs(int y, int x, int m, int n) {
            int count = 0;
            String nowMember = BOARD[y][x];

            for (int i=0; i<4; i++) {
                Queue<int[]> sameQueue = new LinkedList<>();
                for (int j=0; j<3; j++) {
                    int ny = y+DY[i][j];
                    int nx = x+DX[i][j];
                    if (0<=ny && ny<m && 0<=nx && nx<n) {
                        if (nowMember.equals(BOARD[ny][nx])) {
                            sameQueue.add(new int[]{ny, nx});
                        }
                    }
                }
                if (sameQueue.size() == 3) {
                    if (!VISITED[y][x]) {
                        count++;
                        VISITED[y][x] = true;
                    }

                    while (!sameQueue.isEmpty()) {
                        int[] samePoll = sameQueue.poll();
                        if (!VISITED[samePoll[0]][samePoll[1]]) {
                            VISITED[samePoll[0]][samePoll[1]] = true;
                            count++;
                        }

                    }
                }
            }
            return count;
        }

    }
}
