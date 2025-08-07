package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ2638 {

    static int[][] BOARD;
    static int[] DY = {1, 0, -1 ,0};
    static int[] DX = {0, 1, 0, -1};
    static int N, M;
    static int REST_COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputSize = br.readLine().split(" ");
        N = Integer.parseInt(inputSize[0]);
        M = Integer.parseInt(inputSize[1]);

        BOARD = new int[N][M];

        int timeCount = 0;

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                int value = Integer.parseInt(boardInput[j]);
                BOARD[i][j] = value;
                if (value == 1) {
                    REST_COUNT++;
                }
            }
        }

        while (REST_COUNT != 0) {
            int[][] VISITED = new int[N][M];
            setOuterAir(0, 0, VISITED);
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (VISITED[i][j] == 0 && BOARD[i][j] == 1) {
                        melt(i, j, VISITED);
                    }
                }
            }
            timeCount++;
        }

        System.out.println(timeCount);


    }

    private static void melt(int sy, int sx, int[][] VISITED) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy,sx});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int outerAirCount = 0;
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y+DY[i];
                int nx = x+DX[i];

                if (BOARD[ny][nx] == 2) {
                    outerAirCount++;
                }

            }

            if (outerAirCount >= 2) {
                BOARD[y][x] = 0;
                VISITED[y][x] = 1;
                REST_COUNT--;
            }

            for (int i=0; i<4; i++) {
                int ny = y+DY[i];
                int nx = x+DX[i];

                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (VISITED[ny][nx] == 0 && BOARD[ny][nx] == 1) {
                        VISITED[ny][nx] = 1;
                        queue.add(new int[]{ny, nx});
                    } else {
                        VISITED[ny][nx] = 1;
                    }
                }
            }
        }

    }

    private static void setOuterAir(int sy, int sx, int[][] VISITED) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy,sx});
        BOARD[sy][sx] = 2;
        VISITED[sy][sx] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y+DY[i];
                int nx = x+DX[i];

                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (VISITED[ny][nx] == 0 && BOARD[ny][nx] == 0) {
                        VISITED[ny][nx] = 1;
                        BOARD[ny][nx] = 2;
                        queue.add(new int[]{ny, nx});
                    } else if (VISITED[ny][nx] == 0 && BOARD[ny][nx] == 2){
                        VISITED[ny][nx] = 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
