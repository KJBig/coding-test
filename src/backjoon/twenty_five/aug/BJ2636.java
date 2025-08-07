package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ2636 {

    static int N, M;
    static int[][] BOARD;
    static int[] DY = {1, 0, -1 ,0};
    static int[] DX = {0, 1, 0, -1};
    static int REST_COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputSize = br.readLine().split(" ");
        N = Integer.parseInt(inputSize[0]);
        M = Integer.parseInt(inputSize[1]);
        BOARD = new int[N][M];

        int recentCount = 0;
        int timeCount = 0;

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                int nowValue = Integer.parseInt(boardInput[j]);
                BOARD[i][j] = nowValue;
                if (nowValue == 1) {
                    REST_COUNT++;
                }
            }
        }

        while (REST_COUNT != 0) {
            int[][] VISITED = new int[N][M];
            recentCount = REST_COUNT;
            timeCount++;
            setOuterAir(VISITED);

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (VISITED[i][j] == 0 && BOARD[i][j] == 1) {
                        melt(i, j, VISITED);
                    }
                }
            }

        }

        System.out.println(timeCount);
        System.out.println(recentCount);

    }

    private static void melt(int sy, int sx, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy, sx});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y+DY[i];
                int nx = x+DX[i];
                if (BOARD[ny][nx] == 2) {
                    visited[y][x] = 1;
                    BOARD[y][x] = 0;
                    REST_COUNT--;
                    break;
                }
            }

            for (int i=0; i<4; i++) {
                int ny = y+DY[i];
                int nx = x+DX[i];
                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (visited[ny][nx] == 0 && BOARD[ny][nx] == 1) {
                        visited[ny][nx] = 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static void setOuterAir(int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        BOARD[0][0] = 2;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y+DY[i];
                int nx = x+DX[i];

                if (0<=ny && ny<N && 0<=nx && nx<M) {
                    if (visited[ny][nx] == 0 && BOARD[ny][nx] == 0) {
                        visited[ny][nx] = 1;
                        BOARD[ny][nx] = 2;
                        queue.add(new int[]{ny, nx});
                    } else if (visited[ny][nx] == 0 && BOARD[ny][nx] == 2){
                        visited[ny][nx] = 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

    }
}
