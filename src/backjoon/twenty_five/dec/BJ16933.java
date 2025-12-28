//package backjoon.twenty_five.dec;
//
//import java.io.*;
//import java.util.*;
//
//public class BJ16933 {
//    static int N, M, K;
//    static int[][] BOARD;
//    static int[][][] VISITED;
//    static int[] DY = {1, 0, -1, 0};
//    static int[] DX = {0, 1, 0, -1};
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        N = Integer.parseInt(input[0]);
//        M = Integer.parseInt(input[1]);
//        K = Integer.parseInt(input[2]);
//        BOARD = new int[N][M];
//        VISITED = new int[N][M][K+1];
//
//        for (int i=0; i<N; i++) {
//            String[] boardInput = br.readLine().split("");
//            for (int j=0; j<M; j++) {
//                BOARD[i][j] = Integer.parseInt(boardInput[j]);
//            }
//        }
//
//        bfs();
//
//        int minValue = Integer.MAX_VALUE;
//
//        for (int i=0; i<=K; i++) {
//            if (VISITED[N-1][M-1][i] != 0) {
//                minValue = Math.min(minValue, VISITED[N-1][M-1][i]);
//            }
//        }
//
//        if (minValue == Integer.MAX_VALUE) {
//            minValue = -1;
//        }
//
//        System.out.println(minValue);
//
////        for (int l=0; l<=K; l++) {
////            System.out.println("break " + l + "=========");
////            for (int i = 0; i < N; i++) {
////                for (int j = 0; j < M; j++) {
////                    System.out.print(VISITED[i][j][l]);
////                }
////                System.out.println();
////            }
////        }
//
//    }
//
//    private static void bfs() {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0, 0, 0});
//        VISITED[0][0][0] = 1;
//
//        while (!queue.isEmpty()) {
//            int[] poll = queue.poll();
//            int nowY = poll[0];
//            int nowX = poll[1];
//            int breakCount = poll[2];
//            int time = poll[3]; // 0->낮, 1->밤
//
//            for (int i=0; i<4; i++) {
//                int nextY = nowY + DY[i];
//                int nextX = nowX + DX[i];
//                if (0<=nextY && nextY<N && 0<=nextX && nextX<M) {
//                    if (BOARD[nextY][nextX] == 0) {
//                        if (VISITED[nextY][nextX][breakCount] == 0) {
//                            VISITED[nextY][nextX][breakCount] = VISITED[nowY][nowX][breakCount] + 1;
//                            queue.add(new int[]{nextY, nextX, breakCount, (time + 1) % 2});
//                        } else if (VISITED[nextY][nextX][breakCount] > VISITED[nowY][nowX][breakCount] + 1) {
//                            VISITED[nextY][nextX][breakCount] = VISITED[nowY][nowX][breakCount] + 1;
//                            queue.add(new int[]{nextY, nextX, breakCount, (time + 1) % 2});
//                        }
//                    } else {
//                        if (breakCount >= K) continue;
//
//                        if (time==0) {
//                            if (VISITED[nextY][nextX][breakCount+1] == 0) {
//                                VISITED[nextY][nextX][breakCount+1] = VISITED[nowY][nowX][breakCount] + 1;
//                                queue.add(new int[]{nextY, nextX, breakCount+1, (time + 1) % 2});
//                            } else if (VISITED[nextY][nextX][breakCount+1] > VISITED[nowY][nowX][breakCount] + 1) {
//                                VISITED[nextY][nextX][breakCount+1] = VISITED[nowY][nowX][breakCount] + 1;
//                                queue.add(new int[]{nextY, nextX, breakCount+1, (time + 1) % 2});
//                            }
//                        } else {
//                            if (VISITED[nextY][nextX][breakCount+1] == 0) {
//                                VISITED[nextY][nextX][breakCount+1] = VISITED[nowY][nowX][breakCount] + 2;
//                                queue.add(new int[]{nextY, nextX, breakCount+1, time});
//                            } else if (VISITED[nextY][nextX][breakCount+1] > VISITED[nowY][nowX][breakCount] + 2) {
//                                VISITED[nextY][nextX][breakCount+1] = VISITED[nowY][nowX][breakCount] + 2;
//                                queue.add(new int[]{nextY, nextX, breakCount+1, time});
//                            }
//                        }
//
//                    }
//
//                }
//            }
//        }
//    }
//}

package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ16933 {
    static int N, M, K;
    static int[][] BOARD;
    static int[][][] VISITED;
    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        BOARD = new int[N][M];
        VISITED = new int[N][M][(K + 1) * 2];

        for (int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();

        int minValue = Integer.MAX_VALUE;
        for (int b=0; b<=K; b++) {
            for (int t=0; t<2; t++) {
                int v = VISITED[N - 1][M - 1][b * 2 + t];
                if (v != 0) minValue = Math.min(minValue, v);
            }
        }

        System.out.println(minValue == Integer.MAX_VALUE ? -1 : minValue);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // time: 0=낮, 1=밤
        queue.add(new int[]{0, 0, 0, 0});
        VISITED[0][0][0 * 2 + 0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];
            int breakCount = poll[2];
            int time = poll[3];

            int nowDist = VISITED[nowY][nowX][breakCount * 2 + time];

            for (int i=0; i<4; i++) {
                int nextY = nowY + DY[i];
                int nextX = nowX + DX[i];

                if (nextY<0 || nextY>=N || nextX<0 || nextX>=M) continue;

                int nextTime = 1 - time;

                if (BOARD[nextY][nextX] == 0) {
                    int idx = breakCount * 2 + nextTime;
                    if (VISITED[nextY][nextX][idx] == 0) {
                        VISITED[nextY][nextX][idx] = nowDist + 1;
                        queue.add(new int[]{nextY, nextX, breakCount, nextTime});
                    }
                } else {
                    if (breakCount >= K) continue;

                    if (time == 0) {
                        int idx = (breakCount + 1) * 2 + nextTime;
                        if (VISITED[nextY][nextX][idx] == 0) {
                            VISITED[nextY][nextX][idx] = nowDist + 1;
                            queue.add(new int[]{nextY, nextX, breakCount + 1, nextTime});
                        }
                    }  else {
                        int waitTime = 0; // 밤(1) -> 대기하면 낮(0)
                        int idx = breakCount * 2 + waitTime;
                        if (VISITED[nowY][nowX][idx] == 0) {
                            VISITED[nowY][nowX][idx] = nowDist + 1;
                            queue.add(new int[]{nowY, nowX, breakCount, waitTime});
                        }
                    }
                }
            }
        }
    }
}

