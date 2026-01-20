package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ1261 {

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int M = Integer.parseInt(init[0]);
        int N = Integer.parseInt(init[1]);
        int[][] BOARD = new int[N][M];
        int[][] VISITED = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            Arrays.fill(VISITED[i], -1);
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        VISITED[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny<0 || N<=ny || nx<0 || M<=nx) {
                    continue;
                }

                int nextValue = VISITED[y][x] + BOARD[ny][nx];

                if (VISITED[ny][nx] == -1) {
                    VISITED[ny][nx] = nextValue;
                    queue.add(new int[]{ny, nx});
                } else if (VISITED[ny][nx] > nextValue) {
                    VISITED[ny][nx] = nextValue;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        System.out.println(VISITED[N-1][M-1]);

    }
}
