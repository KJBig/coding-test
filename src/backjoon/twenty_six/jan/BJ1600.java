package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ1600 {
    static int K, W, H;
    static int[][] BOARD;
    static int[][][] VISITED;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};
    static int[] HY = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] HX = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] sizeInput = br.readLine().split(" ");
        W = Integer.parseInt(sizeInput[0]);
        H = Integer.parseInt(sizeInput[1]);

        if (W==1 && H==1) {
            System.out.println(0);
            return;
        }

        BOARD = new int[H][W];
        VISITED = new int[H][W][K+1];

        for (int i=0; i<H; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<W; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        bfs();

        int minTime = Integer.MAX_VALUE;
        for (int i=0; i<=K; i++) {
            if (VISITED[H-1][W-1][i] != 0) {
                minTime = Math.min(minTime, VISITED[H-1][W-1][i]);
            }
        }

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int time = poll[2];
            int chance = poll[3];


            if (chance < K) {
                for (int i=0; i<8; i++) {
                    int ny = y + HY[i];
                    int nx = x + HX[i];
                    if (0>ny || 0>nx || ny>=H || nx>=W) {
                        continue;
                    }

                    if (BOARD[ny][nx] == 0) {
                        if (VISITED[ny][nx][chance+1] == 0) {
                            VISITED[ny][nx][chance+1] = time+1;
                            queue.add(new int[]{ny, nx, time+1, chance+1});
                        }
                    }
                }
            }

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];
                if (0>ny || 0>nx || ny>=H || nx>=W) {
                    continue;
                }

                if (BOARD[ny][nx] == 0) {
                    if (VISITED[ny][nx][chance] == 0) {
                        VISITED[ny][nx][chance] = time+1;
                        queue.add(new int[]{ny, nx, time+1, chance});
                    }
                }
            }

        }
    }
}