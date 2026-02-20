package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ14716 {

    static int N, M;
    static int[][] BOARD;
    static boolean[][] VISITED;

    static int[] DY = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");

        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        BOARD = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (BOARD[i][j] == 1 && !VISITED[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        VISITED[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            for (int i=0; i<8; i++) {
                int nextY = nowY + DY[i];
                int nextX = nowX + DX[i];

                if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                    continue;
                }

                if (BOARD[nextY][nextX] == 1 && !VISITED[nextY][nextX]) {
                    VISITED[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }
}
