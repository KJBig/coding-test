package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);

        int[][] BOARD = new int[N][M];
        int[][] ANSWER = new int[N][M];

        int[] DY = {1, 0, -1, 0};
        int[] DX = {0, 1, 0, -1};

        for (int i=0; i<N; i++) {
            Arrays.fill(ANSWER[i], -1);
        }

        int targetY = 0;
        int targetX = 0;

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
                if (BOARD[i][j] == 2) {
                    targetY = i;
                    targetX = j;
                }
                if (BOARD[i][j] == 0) {
                    ANSWER[i][j] = 0;
                }
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{targetY, targetX});
        ANSWER[targetY][targetX] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny<0 || N<=ny || nx<0 || M<=nx) {
                    continue;
                }

                if (BOARD[ny][nx] == 1 && ANSWER[ny][nx] == -1) {
                    ANSWER[ny][nx] = ANSWER[y][x]+1;
                    queue.add(new int[]{ny, nx});
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] ints : ANSWER) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
