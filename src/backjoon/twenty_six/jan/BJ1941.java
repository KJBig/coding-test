package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ1941 {

    static int RESULT;
    static int[] SELECTED = new int [7];
    static int[][] MAP = new int [5][5];
    static boolean[][] VISITED;
    static int[] DY = {-1, 0, 1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++) {
            String line = br.readLine();
            for(int j=0; j<5; j++) {
                if(line.charAt(j) == 'S') {
                    MAP[i][j] = 1;
                } else {
                    MAP[i][j] = 0;
                }
            }
        }

        comb(0, 0);

        System.out.println(RESULT);
    }

    private static void comb(int idx, int start) {
        if(idx == 7) {
            int som = 0;
            int yeon = 0;

            VISITED = new boolean [5][5];

            for (int i=0; i<7; i++) {
                int y = SELECTED[i] / 5;
                int x = SELECTED[i] % 5;

                if(MAP[y][x] == 1) {
                    som++;
                } else{
                    yeon++;
                }
                VISITED[y][x] = true;
            }

            if (som >= 4) {
                if (isConnected()) {
                    RESULT++;
                }
            }
            return;
        }

        for (int i=start; i<25; i++) {
            SELECTED[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    private static boolean isConnected() {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(SELECTED[0] / 5, SELECTED[0] % 5));
        VISITED[SELECTED[0] / 5][SELECTED[0] % 5] = false;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            cnt++;

            for(int i=0; i<4; i++) {
                int nextY = now.row + DY[i];
                int nextX = now.col + DX[i];

                if(nextY<0 || nextY>=5 || nextX<0 || nextX>=5|| !VISITED[nextY][nextX]) {
                    continue;
                }

                queue.add(new Point(nextY, nextX));
                VISITED[nextY][nextX] = false;
            }
        }

        if (cnt == 7) {
            return true;
        } else {
            return false;
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
