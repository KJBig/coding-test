package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16932 {

    static int N, M;
    static int[][] BOARD;
    static int[][] COMPONENT_ID;
    static HashMap<Integer, Integer> COMPONENT_SIZE = new HashMap<>();

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        M = Integer.parseInt(initInput[1]);

        BOARD = new int[N][M];
        COMPONENT_ID = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        int maxSize = searchSize();

        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                if (BOARD[y][x] != 0) continue;

                int totalSize = 1;

                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;

                for (int k=0; k<4; k++) {
                    int ny = y + DY[k];
                    int nx = x + DX[k];

                    if (ny<0 || ny>=N || nx<0 || nx>=M) continue;

                    int id = COMPONENT_ID[ny][nx];
                    if (id == 0) continue;

                    if (id == a || id == b || id == c || id == d) continue;

                    if (a == 0) {
                        a = id;
                    } else if (b == 0) {
                        b = id;
                    } else if (c == 0) {
                        c = id;
                    } else {
                        d = id;
                    }

                    totalSize += COMPONENT_SIZE.get(id);
                }

                maxSize = Math.max(maxSize, totalSize);
            }
        }

        System.out.println(maxSize);
    }

    private static int searchSize() {
        boolean[][] visited = new boolean[N][M];
        int nowMaxSize = 0;
        int componentId = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (BOARD[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j, visited, componentId);
                    COMPONENT_SIZE.put(componentId, size);
                    nowMaxSize = Math.max(nowMaxSize, size);
                    componentId++;
                }
            }
        }

        return nowMaxSize;
    }

    private static int bfs(int y, int x, boolean[][] visited, int componentId) {
        int nowSize = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        COMPONENT_ID[y][x] = componentId;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            for (int i=0; i<4; i++) {
                int nextY = nowY + DY[i];
                int nextX = nowX + DX[i];

                if (nextY<0 || nextY>=N || nextX<0 || nextX>=M) continue;

                if (BOARD[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    COMPONENT_ID[nextY][nextX] = componentId;
                    queue.add(new int[]{nextY, nextX});
                    nowSize++;
                }
            }
        }

        return nowSize;
    }
}
