package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_7576 {
    private static int[][] BOARD;
    private static int[][] VISITED;
    private static int[] MX = {0, 1, 0, -1};
    private static int[] MY = {1, 0, -1, 0};

    private static int MAX_NUM = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        BOARD = new int[N][M];
        VISITED = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (BOARD[i][j] == 1 && VISITED[i][j] == 0) {
                    VISITED[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs(queue, N, M);

        if (!isFullFill(N, M)){
            System.out.println(-1);
        } else {
            getMAXNUM(N, M);
            System.out.println(MAX_NUM-1);
        }

    }

    private static void getMAXNUM(int N, int M) {
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                MAX_NUM = Math.max(VISITED[i][j], MAX_NUM);
            }
        }
    }

    private static boolean isFullFill(int N, int M) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (BOARD[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs(Queue<int[]> queue, int N, int M) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + MY[i];
                int tx = nx + MX[i];

                if (ty>=0 && ty<N && tx>=0 && tx<M && BOARD[ty][tx] == 0) {
                    BOARD[ty][tx] = 1;
                    int nextDay = VISITED[ny][nx] + 1;
                    if (VISITED[ty][tx] != 0) {
                        nextDay = Math.min(VISITED[ty][tx], VISITED[ny][nx] + 1);
                    }
                    VISITED[ty][tx] = nextDay;
                    queue.add(new int[]{ty, tx});
                }
            }
        }
    }
}
