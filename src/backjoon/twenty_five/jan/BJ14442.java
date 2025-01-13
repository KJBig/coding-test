package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ14442 {
    static int N, M, K;
    static int[][] BOARD;
    static int[][][] VISITED;
    static int[] DX = {0, 1, 0, -1};
    static int[] DY = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);
        K = Integer.parseInt(sizeInput[2]);

        BOARD = new int[N][M];
        VISITED = new int[K+1][N][M];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        bfs(0, 0);
        int answer = Integer.MAX_VALUE;
        for (int[][] ints : VISITED) {
            if (ints[N-1][M-1] != 0) {
                answer = Math.min(answer, ints[N-1][M-1]);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, y, x});
        VISITED[0][y][x] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int crashCount = poll[0];
            int ny = poll[1];
            int nx = poll[2];

            for (int i=0; i<4; i++) {
                int ty = ny + DY[i];
                int tx = nx + DX[i];

                if (0<=ty && ty<N && 0<=tx && tx<M) {
                    if (BOARD[ty][tx] == 0) {
                        processMove(crashCount, crashCount, ty, tx, ny, nx, queue);
                    } else {
                        if (crashCount < K) {
                            processMove(crashCount,crashCount + 1, ty, tx, ny, nx, queue);
                        }
                    }
                }
            }
        }
    }

    private static void processMove(int oldCrashCount, int newCrashCount, int ty, int tx, int ny, int nx, Queue<int[]> queue) {
        if (VISITED[newCrashCount][ty][tx] == 0) {
            VISITED[newCrashCount][ty][tx] = VISITED[oldCrashCount][ny][nx] + 1;
            queue.add(new int[]{newCrashCount, ty, tx});
        } else {
            if (VISITED[newCrashCount][ty][tx] > VISITED[oldCrashCount][ny][nx] + 1) {
                VISITED[newCrashCount][ty][tx] = VISITED[oldCrashCount][ny][nx] + 1;
                queue.add(new int[]{newCrashCount, ty, tx});
            }
        }
    }
}
