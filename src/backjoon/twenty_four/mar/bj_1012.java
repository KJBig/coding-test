package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_1012 {
    private static int[] MX = {0, 1, 0, -1};
    private static int[] MY = {1, 0, -1, 0};
    private static int[][] BOARD;
    private static int[][] VISITED;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        for (int i=0; i<T; i++) {
            String[] split = br.readLine().split(" ");
            int M = Integer.parseInt(split[0]);
            int N = Integer.parseInt(split[1]);
            int K = Integer.parseInt(split[2]);
            int count = 0;

            BOARD = new int[N][M];
            VISITED = new int[N][M];

            for (int j=0; j<K; j++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                BOARD[y][x] = 1;
            }

            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    if (BOARD[j][k] == 1 && VISITED[j][k] == 0) {
                        bfs(j, k, M, N);
                        count++;
                    }
                }
            }

            result[i] = count;

        }

        for (int i=0; i< result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static void bfs(int y, int x, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + MY[i];
                int tx = nx + MX[i];

                if (ty>=0 && ty<n && tx>=0 && tx<m && BOARD[ty][tx] == 1 && VISITED[ty][tx] == 0) {
                    VISITED[ty][tx] = 1;
                    queue.offer(new int[]{ty, tx});
                }
            }

        }
    }

}
