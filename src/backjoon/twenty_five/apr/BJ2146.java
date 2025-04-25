package backjoon.twenty_five.apr;

import java.io.*;
import java.util.*;

public class BJ2146 {
    static int[][] BOARD;
    static boolean[][] VISITED;
    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};
    static int N;

    static int MIN_SIZE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];

        for (int i=0; i<N; i++) {
            String[] inputBoard = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                BOARD[i][j] = Integer.parseInt(inputBoard[j]);
            }
        }

        VISITED = new boolean[N][N];
        int landFlag = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (BOARD[i][j] == 1 && !VISITED[i][j]) {
                    divideLand(i, j, landFlag);
                    landFlag++;
                }

            }
        }


        for (int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (BOARD[i][j] != 0) {
                    trackingBoard(i, j, BOARD[i][j]);
                }

            }
        }

        System.out.println(MIN_SIZE);

    }

    private static void trackingBoard(int sy, int sx, int signal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy, sx, 0});
        boolean[][] subVisited = new boolean[N][N];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int count = poll[2];

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];
                if (0<=ny && ny<N && 0<=nx && nx<N) {
                    if (BOARD[ny][nx] != signal && !subVisited[ny][nx]) {
                        if (BOARD[ny][nx] == 0) {
                            subVisited[ny][nx] = true;
                            queue.add(new int[]{ny, nx, count + 1});
                        } else {
                            MIN_SIZE = Math.min(count, MIN_SIZE);
                        }
                    }
                }
            }
        }
    }

    private static void divideLand(int sy, int sx, int landFlag) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy, sx});

        VISITED[sy][sx] = true;
        BOARD[sy][sx] = landFlag;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];
                if (0<=ny && ny<N && 0<=nx && nx<N) {
                    if (BOARD[ny][nx] == 1 && !VISITED[ny][nx]) {
                        VISITED[ny][nx] = true;
                        BOARD[ny][nx] = landFlag;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

    }
}
