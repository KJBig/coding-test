package backjoon.twenty_five.jul;

import java.io.*;
import java.util.*;

public class BJ2194 {
    static int N, M, A, B;
    static boolean[][] OBSTACLE_MAP;
    static boolean[][] VISITED;
    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        OBSTACLE_MAP = new boolean[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            OBSTACLE_MAP[y][x] = true;
        }

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int endY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;

        int result = bfs(startY, startX, endY, endX);
        System.out.println(result);
    }

    private static int bfs(int startY, int startX, int endY, int endX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        VISITED[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int moveCount = current[2];

            if (y == endY && x == endX) {
                return moveCount;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (isInBounds(ny, nx) && !VISITED[ny][nx] && canMove(ny, nx)) {
                    VISITED[ny][nx] = true;
                    queue.add(new int[]{ny, nx, moveCount + 1});
                }
            }
        }

        return -1;
    }

    private static boolean isInBounds(int y, int x) {
        return y >= 0 && x >= 0 && y + A - 1 < N && x + B - 1 < M;
    }

    private static boolean canMove(int y, int x) {
        for (int i = y; i < y + A; i++) {
            for (int j = x; j < x + B; j++) {
                if (OBSTACLE_MAP[i][j]) return false;
            }
        }
        return true;
    }
}
