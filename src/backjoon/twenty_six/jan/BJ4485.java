package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ4485 {

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemIndex = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] BOARD = new int[N][N];
            for (int i=0; i<N; i++) {
                String[] boardInput = br.readLine().split(" ");
                for (int j=0; j<N; j++) {
                    BOARD[i][j] = Integer.parseInt(boardInput[j]);
                }
            }

            int[][] VISITED = new int[N][N];

            for (int i=0; i<N; i++) {
                Arrays.fill(VISITED[i], -1);
            }

            VISITED[0][0] = BOARD[0][0];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];

                for (int i=0; i<4; i++) {
                    boolean canGo = false;
                    int nextY = y + DY[i];
                    int nextX = x + DX[i];

                    if (nextY<0 || N<=nextY || nextX<0 || N<=nextX) {
                        continue;
                    }

                    int nextValue = VISITED[y][x] + BOARD[nextY][nextX];

                    if (VISITED[nextY][nextX] == -1) {
                        VISITED[nextY][nextX] = nextValue;
                        canGo = true;
                    } else if (VISITED[nextY][nextX] > nextValue) {
                        VISITED[nextY][nextX] = nextValue;
                        canGo = true;
                    }

                    if (canGo) {
                        queue.add(new int[]{nextY, nextX});
                    }

                }
            }

            System.out.println("Problem " + problemIndex + ": " + VISITED[N-1][N-1]);
            problemIndex++;
        }

    }
}
