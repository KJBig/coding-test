package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ3055 {

    static int N, M;
    static String[][] BOARD;
    static int[][] GO_VISITED;
    static int[][] WATER_VISITED;
    static int[] DX = {0, 1, 0, -1};
    static int[] DY = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        BOARD = new String[N][M];
        GO_VISITED = new int[N][M];
        WATER_VISITED = new int[N][M];

        int[] initGoPosition = new int[2];
        int[] initBiPosition = new int[2];
        List<int[]> initWaPosition = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = boardInput[j];
                if (boardInput[j].equals("S")) {
                    initGoPosition[0] = i;
                    initGoPosition[1] = j;
                }

                if (boardInput[j].equals("D")) {
                    initBiPosition[0] = i;
                    initBiPosition[1] = j;
                }

                if (boardInput[j].equals("*")) {
                    initWaPosition.add(new int[]{i, j});
                }
            }
        }

        for (int[] ints : initWaPosition) {
            waterProcess(ints, initBiPosition);
        }
        goProcess(initGoPosition);

        int answer = GO_VISITED[initBiPosition[0]][initBiPosition[1]]-1;
        if (answer == -1){
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }

    }

    private static void goProcess(int[] initPosition) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(initPosition);
        GO_VISITED[initPosition[0]][initPosition[1]] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ty = y + DY[i];
                int tx = x + DX[i];
                if (0<=ty && ty<N && 0<=tx && tx<M) {
                    if (!BOARD[ty][tx].equals("X") && ((WATER_VISITED[ty][tx] > GO_VISITED[y][x] +1) || WATER_VISITED[ty][tx] == 0)) {
                        moveProcess(GO_VISITED, queue, y, x, ty, tx);
                    }
                }
            }
        }
    }

    private static void waterProcess(int[] initPosition, int[] biPosition) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(initPosition);
        WATER_VISITED[initPosition[0]][initPosition[1]] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ty = y + DY[i];
                int tx = x + DX[i];
                if (0<=ty && ty<N && 0<=tx && tx<M) {
                    if (!BOARD[ty][tx].equals("X") && !(ty==biPosition[0] && tx==biPosition[1])) {
                        moveProcess(WATER_VISITED, queue, y, x, ty, tx);

                    }
                }
            }
        }

    }

    private static void moveProcess(int[][] visit, Queue<int[]> queue, int y, int x, int ty, int tx) {
        if (visit[ty][tx] == 0) {
            visit[ty][tx] = visit[y][x] + 1;
            queue.add(new int[]{ty, tx});
        } else if (visit[ty][tx] > visit[y][x] + 1) {
            visit[ty][tx] = visit[y][x] + 1;
            queue.add(new int[]{ty, tx});
        }
    }
}
