package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17836 {
    static int N, M, T;
    static int[] DX = {0, 1, 0, -1};
    static int[] DY = {1, 0, -1, 0};
    static int[][] BOARD;
    static int[][][] VISIT_TIME;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);
        T = Integer.parseInt(sizeInput[2]);

        BOARD = new int[N][M];
        VISIT_TIME = new int[2][N][M];

        for (int i=0; i<N; i++) {
            String[] number = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(number[j]);
            }
        }

        bfs();

        int answer = Integer.MAX_VALUE;

        for (int i=0; i<=1; i++) {
            if (VISIT_TIME[i][N-1][M-1] != 0) {
                answer = Math.min(answer, VISIT_TIME[i][N - 1][M - 1]);
            }
        }

        if (answer > T) {
            answer = Integer.MAX_VALUE;
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println("Fail");
        } else {
            System.out.println(answer);
        }

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int sword = poll[2];

            for (int i=0; i<4; i++) {
                int ty = y + DY[i];
                int tx = x + DX[i];
                if (0<=ty && ty<N && 0<=tx && tx<M) {
                    if (sword == 1) { // 검을 얻은 경우
                        if (VISIT_TIME[sword][ty][tx] == 0 || VISIT_TIME[sword][ty][tx] > VISIT_TIME[sword][y][x] + 1) {
                            VISIT_TIME[sword][ty][tx] = VISIT_TIME[sword][y][x] + 1;
                            queue.add(new int[]{ty, tx, sword});
                        }
                    } else { // 검을 얻지 않은 경우
                        if (BOARD[ty][tx] != 1) {
                            if (VISIT_TIME[sword][ty][tx] == 0 || VISIT_TIME[sword][ty][tx] > VISIT_TIME[sword][y][x] + 1) {
                                VISIT_TIME[sword][ty][tx] = VISIT_TIME[sword][y][x] + 1;
                                queue.add(new int[]{ty, tx, sword});
                            }
                            if (BOARD[ty][tx] == 2) {
                                VISIT_TIME[sword+1][ty][tx] = VISIT_TIME[sword][y][x] + 1;
                                queue.add(new int[]{ty, tx, sword+1});
                            }
                        }
                    }
                }
            }
        }
    }
}
