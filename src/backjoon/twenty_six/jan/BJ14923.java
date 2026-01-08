package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ14923 {

    static int N, M;
    static int[][] BOARD;
    static int[][][] DIST;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        M = Integer.parseInt(initInput[1]);

        String[] startInput = br.readLine().split(" ");
        String[] endInput = br.readLine().split(" ");

        int startY = Integer.parseInt(startInput[0]) - 1;
        int startX = Integer.parseInt(startInput[1]) - 1;
        int endY = Integer.parseInt(endInput[0]) - 1;
        int endX = Integer.parseInt(endInput[1]) - 1;

        BOARD = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(row[j]);
            }
        }

        DIST = new int[N][M][2];
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                DIST[i][j][0] = -1;
                DIST[i][j][1] = -1;
            }
        }

        int ans = bfs(startY, startX, endY, endX);
        System.out.println(ans);
    }

    private static int bfs(int sy, int sx, int ey, int ex) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sy, sx, 0));
        DIST[sy][sx][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y, x = cur.x, b = cur.b;

            if (y == ey && x == ex) {
                return DIST[y][x][b];
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + DY[dir];
                int nx = x + DX[dir];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                if (BOARD[ny][nx] == 0) {
                    if (DIST[ny][nx][b] == -1) {
                        DIST[ny][nx][b] = DIST[y][x][b] + 1;
                        queue.add(new Node(ny, nx, b));
                    }
                } else {
                    if (b == 0 && DIST[ny][nx][1] == -1) {
                        DIST[ny][nx][1] = DIST[y][x][b] + 1;
                        queue.add(new Node(ny, nx, 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int y, x, b;
        Node(int y, int x, int b) {
            this.y = y;
            this.x = x;
            this.b = b;
        }
    }

}
