package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ2583 {

    static int M, N, K;
    static boolean[][] VISITED;
    static int[][] BOARD;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        M = Integer.parseInt(initInput[0]);
        N = Integer.parseInt(initInput[1]);
        K = Integer.parseInt(initInput[2]);

        BOARD = new int[M][N];

        for (int i=0; i<K; i++) {
            String[] input = br.readLine().split(" ");
            int sx = Integer.parseInt(input[0]);
            int sy = Integer.parseInt(input[1]);
            int ex = Integer.parseInt(input[2]);
            int ey = Integer.parseInt(input[3]);


            for (int x=sx; x<ex; x++) {
                for (int y=sy; y<ey; y++) {
                    BOARD[y][x] = 1;
                }
            }
        }

        VISITED = new boolean[M][N];
        PriorityQueue<Integer> sizeQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (BOARD[i][j] == 0 && !VISITED[i][j]) {
                    int size = bfs(i, j);
                    sizeQueue.add(size);
                }
            }
        }

        System.out.println(sizeQueue.size());
        while (!sizeQueue.isEmpty()) {
            System.out.print(sizeQueue.poll() + " ");
        }

    }

    private static int bfs(int y, int x) {
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        VISITED[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            for (int i=0; i<4; i++) {
                int nextY = nowY + DY[i];
                int nextX = nowX + DX[i];

                if (nextY<0 || M<=nextY || nextX<0 || N<=nextX) {
                    continue;
                }

                if (BOARD[nextY][nextX] == 0 && !VISITED[nextY][nextX]) {
                    VISITED[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                    size++;
                }
            }
        }

        return size;
    }

}
