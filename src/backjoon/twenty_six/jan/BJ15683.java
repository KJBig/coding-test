package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ15683 {

    static int N, M;
    static int[][] BOARD;
    static List<CCTV> CCTVS = new ArrayList<>();
    static int ANSWER = Integer.MAX_VALUE;

    static final int[] DY = {-1, 0, 1, 0};
    static final int[] DX = {0, 1, 0, -1};

    static final int[][][] DIRS = {
            {},
            { {0}, {1}, {2}, {3} }, // 1번으로 4가지 방향
            { {0,2}, {1,3} }, // 2번으로 2가지 방향
            { {0,1}, {1,2}, {2,3}, {3,0} }, // 3번으로 4가지 방향
            { {0,1,2}, {1,2,3}, {2,3,0}, {3,0,1} }, // 4번 4가지 방향
            { {0,1,2,3} } // 5번으로 1방향
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        M = Integer.parseInt(initInput[1]);

        BOARD = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
                if (BOARD[i][j] >= 1 && BOARD[i][j] <= 5) {
                    CCTVS.add(new CCTV(i, j, BOARD[i][j]));
                }
            }
        }

        dfs(0, BOARD);
        System.out.println(ANSWER);
    }

    static void dfs(int index, int[][] cur) {
        if (index == CCTVS.size()) {
            ANSWER = Math.min(ANSWER, countBlind(cur));
            return;
        }

        CCTV cam = CCTVS.get(index);
        int type = cam.type;

        for (int[] dirSet : DIRS[type]) {
            int[][] next = copy(cur);
            for (int d : dirSet) {
                watch(next, cam.y, cam.x, d);
            }
            dfs(index + 1, next);
        }
    }

    static void watch(int[][] map, int y, int x, int direction) {
        int nextY = y + DY[direction];
        int nextX = x + DX[direction];
        while (0<=nextY && nextY<N && 0<=nextX && nextX<M) {
            if (map[nextY][nextX] == 6) {
                break;
            }

            if (map[nextY][nextX] == 0) {
                map[nextY][nextX] = -1;
            }

            nextY += DY[direction];
            nextX += DX[direction];
        }
    }

    static int countBlind(int[][] map) {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int[][] copy(int[][] src) {
        int[][] dst = new int[N][M];
        for (int i=0; i<N; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, M);
        }
        return dst;
    }

    static class CCTV {
        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}
