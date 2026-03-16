package backjoon.twenty_six.mar;

import java.io.*;
import java.util.*;

public class BJ11559 {
    static int N = 12;
    static int M = 6;
    static String[][] BOARD;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BOARD = new String[N][M];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = boardInput[j];
            }
        }

        int crashCount = 0;
        while (true) {
            int nowCrash = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (!BOARD[i][j].equals(".")) {
                        boolean isCrashed = bfs(i, j);
                        if (isCrashed) {
                            nowCrash++;
                        }
                    }
                }
            }

            if (nowCrash == 0) {
                break;
            }
            downProcess();
            crashCount++;
        }

        System.out.println(crashCount);
    }

    private static void downProcess() {
        for (int i=N-1; i>=0; i--) {
            for (int j=0; j<M; j++) {
                if (!BOARD[i][j].equals(".")) {
                    int y = i;
                    int nextY = i+1;
                    while (nextY < N) {
                        if (!BOARD[nextY][j].equals(".")) {
                            break;
                        }
                        String temp = BOARD[nextY][j];
                        BOARD[nextY][j] = BOARD[y][j];
                        BOARD[y][j] = temp;
                        y = nextY;
                        nextY++;
                    }
                }
            }
        }
    }

    private static boolean bfs(int i, int j) {
        boolean isCrashed = false;
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> targets = new LinkedList<>();
        queue.add(new int[]{i, j});
        targets.add(new int[]{i, j});
        boolean[][] visited = new boolean[N][M];
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int k=0; k<4; k++) {
                int ny = y +DY[k];
                int nx = x +DX[k];

                if (ny<0 || N<=ny || nx<0 || M<=nx) {
                    continue;
                }

                if (BOARD[ny][nx].equals(BOARD[y][x]) && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    targets.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

        if (targets.size() >= 4) {
            isCrashed = true;
            while (!targets.isEmpty()) {
                int[] poll = targets.poll();
                int y = poll[0];
                int x = poll[1];
                BOARD[y][x] = ".";
            }
        }

        return isCrashed;
    }
}
