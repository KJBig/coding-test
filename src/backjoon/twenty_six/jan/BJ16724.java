package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16724 {

    static int N, M;
    static String[][] BOARD;
    static int[][] VISITED;

    static int SAFE_ZONE_COUNT = 0;

    static int[] DY = {-1, 0, 1, 0};
    static int[] DX = {0, 1, 0, -1};
    static HashMap<String, Integer> DIRECTION_INDEX = new HashMap<>();

    public static void main(String[] args) throws Exception {

        DIRECTION_INDEX.put("U", 0);
        DIRECTION_INDEX.put("R", 1);
        DIRECTION_INDEX.put("D", 2);
        DIRECTION_INDEX.put("L", 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new String[N][M];
        VISITED = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                BOARD[i][j] = boardInput[j];
            }
        }

        int cycle = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (VISITED[i][j] == 0) {
                    bfs(i, j, cycle);
                    cycle++;
                }
            }
        }

        System.out.println(SAFE_ZONE_COUNT);

    }

    private static void bfs(int y, int x, int nowIndex) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        VISITED[y][x] = nowIndex;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            String nowDirection = BOARD[nowY][nowX];
            int directionIndex = DIRECTION_INDEX.get(nowDirection);
            int nextY = nowY + DY[directionIndex];
            int nextX = nowX + DX[directionIndex];

            if (VISITED[nextY][nextX] == 0) {
                VISITED[nextY][nextX] = nowIndex;
                queue.add(new int[]{nextY, nextX});
            } else {
                if (VISITED[nextY][nextX] == nowIndex) {
                    SAFE_ZONE_COUNT++;
                }
            }
        }

    }
}
