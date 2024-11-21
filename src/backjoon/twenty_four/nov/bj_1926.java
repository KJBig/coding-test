package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_1926 {

    static int[][] BOARD;
    static int[][] VISITED;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = br.readLine().split(" ");
        N = Integer.parseInt(sizes[0]);
        M = Integer.parseInt(sizes[1]);

        BOARD = new int[N][M];
        VISITED = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int count = 0;
        int maxSize = 0;
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (VISITED[i][j] == 0 && BOARD[i][j] == 1) {
                    VISITED[i][j] = 1;
                    int size = bfs(i, j);
                    maxSize = Math.max(maxSize, size);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int bfs(int y, int x) {
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i=0; i<4; i++) {
                int ty = poll[0] + DY[i];
                int tx = poll[1] + DX[i];

                if (0<=ty && ty<N && 0<=tx && tx<M) {
                    if (VISITED[ty][tx] == 0 && BOARD[ty][tx] == 1) {
                        VISITED[ty][tx] = 1;
                        queue.add(new int[]{ty, tx});
                        size++;
                    }
                }
            }
        }

        return size;
    }
}
