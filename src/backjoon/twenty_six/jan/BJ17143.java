package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ17143 {

    static int R, C, M;
    static int[][] BOARD;
    static HashMap<Integer, Shark> SHARKS = new HashMap<>();

    static int[] DY = {0, -1, 1, 0, 0};
    static int[] DX = {0, 0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInput = br.readLine().split(" ");
        R = Integer.parseInt(initInput[0]);
        C = Integer.parseInt(initInput[1]);
        M = Integer.parseInt(initInput[2]);

        BOARD = new int[R+1][C+1];

        for (int i=1; i<=M; i++) {
            String[] data = br.readLine().split(" ");
            int y = Integer.parseInt(data[0]);
            int x = Integer.parseInt(data[1]);
            int s = Integer.parseInt(data[2]);
            int d = Integer.parseInt(data[3]);
            int z = Integer.parseInt(data[4]);

            SHARKS.put(i, new Shark(y, x, s, d, z));
            BOARD[y][x] = i;
        }


        // 1. 낚시왕 이동
        int answer = 0;
        for (int i=1; i<=C; i++) {
            answer += catchShark(i);
            moveShark();
        }

        System.out.println(answer);

    }

    private static void moveShark() {
        int[][] nextBoard = new int[R + 1][C + 1];
        HashMap<Integer, Shark> nextSharks = new HashMap<>();

        for (Map.Entry<Integer, Shark> entry : SHARKS.entrySet()) {
            int idx = entry.getKey();
            Shark shark = entry.getValue();

            int[] next = getNextLocation(shark.y, shark.x, shark.speed, shark.direction);
            int ny = next[0], nx = next[1], nd = next[2];

            shark.y = ny;
            shark.x = nx;
            shark.direction = nd;

            if (nextBoard[ny][nx] == 0) {
                nextBoard[ny][nx] = idx;
                nextSharks.put(idx, shark);
            } else {
                int otherIdx = nextBoard[ny][nx];
                Shark other = nextSharks.get(otherIdx);

                if (shark.size > other.size) {
                    nextBoard[ny][nx] = idx;
                    nextSharks.remove(otherIdx);
                    nextSharks.put(idx, shark);
                }
            }
        }

        BOARD = nextBoard;
        SHARKS = nextSharks;
    }


    private static int[] getNextLocation(int y, int x, int speed, int direction) {
        Deque<int[]> dq = new ArrayDeque<>();

        if (direction == 1 || direction == 2) {
            speed %= (2 * (R - 1));
        } else {
            speed %= (2 * (C - 1));
        }

        dq.add(new int[]{y, x, direction});

        while (speed-- > 0) {
            int[] cur = dq.poll();
            int cy = cur[0];
            int cx = cur[1];
            int dir = cur[2];

            int ny = cy + DY[dir];
            int nx = cx + DX[dir];

            if (ny < 1 || ny > R || nx < 1 || nx > C) {
                dir = reverse(dir);
                ny = cy + DY[dir];
                nx = cx + DX[dir];
            }

            dq.add(new int[]{ny, nx, dir});
        }

        return dq.peek();
    }

    private static int reverse(int d) {
        if (d == 1) return 2;
        if (d == 2) return 1;
        if (d == 3) return 4;
        return 3;
    }



    private static int catchShark(int col) {
        int caughtSharkSize = 0;
        for (int i=1; i<=R; i++) {
            int nowSharkIndex = BOARD[i][col];
            if (nowSharkIndex != 0) {
                BOARD[i][col] = 0;
                Shark shark = SHARKS.remove(nowSharkIndex);

                caughtSharkSize = shark.size;
                break;
            }
        }

        return caughtSharkSize;
    }

    static class Shark {
        int y;
        int x;
        int speed;
        int direction;
        int size;

        public Shark(int y, int x, int speed, int direction, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }
}
