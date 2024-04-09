package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_10026 {
    private static int[] MX = {0, 1, 0, -1};
    private static int[] MY = {1, 0, -1, 0};
    private static String[][] BOARD;
    private static int[][] VISITED;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BOARD = new String[N][N];
        VISITED = new int[N][N];
        int count = 0;
        int colorCount = 0;


        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j<N; j++) {
                BOARD[i][j] = split[j];
            }
        }

        // 정상인
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (VISITED[j][k] == 0) {
                    bfs(j, k, N);
                    count++;
                }
            }
        }

        VISITED = new int[N][N];
        // 색 변경
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (BOARD[j][k].equals("G") && VISITED[j][k] == 0) {
                    changeColor(j, k, N);
                }
            }
        }

        VISITED = new int[N][N];
        // 적록색약
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (VISITED[j][k] == 0) {
                    bfs(j, k, N);
                    colorCount++;
                }
            }
        }

        System.out.println(count + " " + colorCount);

    }

    private static void changeColor(int y, int x, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        BOARD[y][x] = "R";

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + MY[i];
                int tx = nx + MX[i];

                if (ty>=0 && ty<n && tx>=0 && tx<n && BOARD[ty][tx].equals("G") && VISITED[ty][tx] == 0) {
                    VISITED[ty][tx] = 1;
                    BOARD[ty][tx] = "R";
                    queue.offer(new int[]{ty, tx});
                }
            }

        }
    }

    private static void bfs(int y, int x, int n) {
        String nowColor = BOARD[y][x];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + MY[i];
                int tx = nx + MX[i];

                if (ty>=0 && ty<n && tx>=0 && tx<n && BOARD[ty][tx].equals(nowColor) && VISITED[ty][tx] == 0) {
                    VISITED[ty][tx] = 1;
                    queue.offer(new int[]{ty, tx});
                }
            }

        }
    }

}
