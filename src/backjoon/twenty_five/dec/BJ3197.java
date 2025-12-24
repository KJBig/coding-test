package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ3197 {
    static int R, C;
    static String[][] BOARD;
    static int[] DX = {0, 1, 0, -1};
    static int[] DY = {1, 0, -1, 0};
    static int[][] SWAN_LOCATION = new int[2][2];
    static boolean[][] MALT_VISITED, SWAN_VISITED;
    static Queue<int[]> SWAN_QUEUE = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        R = Integer.parseInt(initInput[0]);
        C = Integer.parseInt(initInput[1]);
        BOARD = new String[R][C];
        MALT_VISITED = new boolean[R][C];
        SWAN_VISITED = new boolean[R][C];
        int swanCount = 0;
        int endY;
        int endX;
        Queue<int[]> waterQueue = new LinkedList<>();

        for (int i=0; i<R; i++) {
            String[] boardInput = br.readLine().split("");
            for (int j=0; j<C; j++) {
                BOARD[i][j] = boardInput[j];
                if (boardInput[j].equals("L")) {
                    SWAN_LOCATION[swanCount][0] = i;
                    SWAN_LOCATION[swanCount][1] = j;
                    swanCount++;
                    waterQueue.add(new int[]{i, j});
                }
                if (boardInput[j].equals(".")) {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        endY = SWAN_LOCATION[1][0];
        endX = SWAN_LOCATION[1][1];
        SWAN_QUEUE.add(new int[]{SWAN_LOCATION[0][0], SWAN_LOCATION[0][1]});
        SWAN_VISITED[SWAN_LOCATION[0][0]][SWAN_LOCATION[0][1]] = true;


        int day = 0;

        while (true) {
            if (checkConnection(endY, endX)) {
                break;
            }
            waterQueue = maltIce(waterQueue);

            day++;
        }
        System.out.println(day);
    }

    private static boolean checkConnection(int endY, int endX) {
        Queue<int[]> nextSqanQueue = new LinkedList<>();

        while (!SWAN_QUEUE.isEmpty()) {
            int[] poll = SWAN_QUEUE.poll();

            for (int i=0; i<4; i++) {
                int ny = poll[0] + DY[i];
                int nx = poll[1] + DX[i];

                if (0<=ny && ny<R && 0<=nx && nx<C) {
                    if (ny==endY && nx==endX) {
                        return true;
                    }
                    if (SWAN_VISITED[ny][nx]) continue;

                    SWAN_VISITED[ny][nx] = true;

                    if (BOARD[ny][nx].equals("X")) {
                        nextSqanQueue.add(new int[]{ny, nx});
                    } else {
                        SWAN_QUEUE.add(new int[]{ny, nx});
                    }
                }
            }
        }

        SWAN_QUEUE = nextSqanQueue;
        return false;
    }

    private static Queue<int[]> maltIce(Queue<int[]> waterQueue) {
        Queue<int[]> nextQueue = new LinkedList<>();

        while (!waterQueue.isEmpty()) {
            int[] poll = waterQueue.poll();

            for (int i=0; i<4; i++) {
                int ny = poll[0] + DY[i];
                int nx = poll[1] + DX[i];

                if (0<=ny && ny<R && 0<=nx && nx<C) {
                    if (MALT_VISITED[ny][nx]) continue;
                    MALT_VISITED[ny][nx] = true;

                    if (BOARD[ny][nx].equals("X")) {
                        BOARD[ny][nx] = ".";
                        nextQueue.add(new int[]{ny, nx});
                    }
                }

            }
        }

        return nextQueue;
    }

}
