package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16954 {

    static final int N = 8;
    static char[][] BOARD = new char[N][N];

    static final int[] DY = {1, 1, 0, -1, -1, -1, 0, 1, 0};
    static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<N; i++) {
            String boardInput = br.readLine();
            for (int j=0; j<N; j++) {
                BOARD[i][j] = boardInput.charAt(j);
            }
        }

        System.out.println(canEscape() ? 1 : 0);
    }

    private static boolean canEscape() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N-1, 0});

        for (int turn=0; turn<9; turn++) {
            int size = queue.size();
            boolean[][] visited = new boolean[N][N];

            for (int i=0; i<size; i++) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];

                if (BOARD[y][x] == '#') {
                    continue;
                }

                if (y == 0 && x == N-1) {
                    return true;
                }

                for (int d=0; d<9; d++) {
                    int ny = y + DY[d];
                    int nx = x + DX[d];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                        continue;
                    }

                    if (BOARD[ny][nx] == '#') {
                        continue;
                    }

                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }

            moveWallsDown();

            if (queue.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    private static void moveWallsDown() {
        for (int y=N-1; y>=1; y--) {
            for (int x=0; x<N; x++) {
                BOARD[y][x] = BOARD[y-1][x];
            }
        }

        for (int x=0; x<N; x++) {
            BOARD[0][x] = '.';
        }
    }
}
