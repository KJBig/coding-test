package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_16234 {

    static int SUM = 0;
    static List<int[]> TARGET = new ArrayList<>();
    static int[][] BOARD;
    static int[][] VISITED;
    static int[] TY = {0, -1, 0, 1};
    static int[] TX = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int L = Integer.parseInt(split[1]);
        int R = Integer.parseInt(split[2]);

        BOARD = new int[N][N];
        VISITED = new int[N][N];

        int answer = 0;


        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                BOARD[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true) {
            int count = 0;
            for (int row=0; row<N; row++) {
                for (int col=0; col<N; col++) {
                    if (VISITED[row][col] == 0) {
                        bfs(N, L, R, row, col);

                        if (TARGET.size() != 0) {
                            changeValue();
                            SUM = 0;
                            TARGET.clear();
                            count++;
                        }
                    }
                }
            }

            if (count == 0) {
                break;
            }

            VISITED = new int[N][N];
            answer++;
        }

        System.out.println(answer);

    }

    private static void changeValue() {
        int value = SUM / TARGET.size();

        for (int[] now : TARGET) {
            BOARD[now[0]][now[1]] = value;
        }
    }

    private static void bfs(int N, int L, int R, int iy, int ix) {
        Queue<int[]> queue = new LinkedList<>();
        int[] initTarget = {iy, ix};
        queue.add(initTarget);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i=0; i<4; i++) {
                int y = poll[0] + TY[i];
                int x = poll[1] + TX[i];
                if (0<=y && y< N && 0<=x && x< N) {
                    int value = BOARD[poll[0]][poll[1]] - BOARD[y][x];
                    if (value < 0) {
                        value *= -1;
                    }
                    if (VISITED[y][x] == 0 && L <=value && value<= R) {
                        SUM += BOARD[y][x];
                        VISITED[y][x] = 1;
                        int[] now = {y, x};
                        TARGET.add(now);
                        queue.add(now);
                    }
                }
            }
        }

    }
}
