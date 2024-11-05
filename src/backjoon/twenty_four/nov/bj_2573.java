package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2573 {

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    static int N;
    static int M;

    static int[][] BOARD;
    static int[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boardSize = br.readLine().split(" ");
        N = Integer.parseInt(boardSize[0]);
        M = Integer.parseInt(boardSize[1]);

        BOARD = new int[N][M];
        int year = 0;

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true) {
            int count = 0;
            VISITED = new int[N][M];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (VISITED[row][col] == 0 && BOARD[row][col] != 0) {
                        trackCount(row, col);
                        count++;
                    }
                }
            }

            if (count == 0) {
                year = 0;
                break;
            }

            if (count > 1) {
                break;
            }

            VISITED = new int[N][M];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (VISITED[row][col] == 0 && BOARD[row][col] != 0) {
                        minusHeight(row, col);
                    }
                }
            }

            year++;
        }

        System.out.println(year);

    }
    private static void trackCount(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        VISITED[y][x] = 1;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + DY[i];
                int tx = nx + DX[i];
                if (0<=ty && ty< N && 0<=tx && tx<M) {
                    if (VISITED[ty][tx] == 0 && BOARD[ty][tx] != 0) {
                        VISITED[ty][tx] = 1;
                        queue.add(new int[]{ty, tx});
                    }
                }
            }
        }

    }

    private static void minusHeight(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        VISITED[y][x] = 1;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + DY[i];
                int tx = nx + DX[i];
                if (0<=ty && ty<N && 0<=tx && tx<M) {
                    if (BOARD[ty][tx] == 0 && BOARD[ny][nx] > 0 && VISITED[ty][tx] == 0) {
                        BOARD[ny][nx]--;
                    }

                    if (VISITED[ty][tx] == 0 && BOARD[ty][tx] != 0) {
                        VISITED[ty][tx] = 1;
                        queue.add(new int[]{ty, tx});
                    }

                }
            }
        }

    }

}
