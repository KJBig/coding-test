package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2589 {
    static int N, M;
    static String[][] BOARD;
    static int[][] VISITED;
    static int[][] DIS;
    static int MAX_NUM = 0;
    static int[] TX = {0, 1, 0, -1};
    static int[] TY = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BOARD = new String[N][M];

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = split[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (BOARD[i][j].equals("L")) {
                    VISITED = new int[N][M];
                    DIS = new int[N][M];
                    bfs(i, j);
                }

            }
        }


        System.out.println(MAX_NUM);

    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        VISITED[y][x] = 1;
        DIS[y][x] = 0;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];
            for (int i=0; i<4; i++) {
                int ney = ny + TY[i];
                int nex = nx + TX[i];
                if (0<=ney && ney<N && 0<=nex && nex<M) {
                    if (BOARD[ney][nex].equals("L") && VISITED[ney][nex] == 0) {
                        VISITED[ney][nex] = 1;
                        queue.add(new int[]{ney, nex});
                        if (DIS[ney][nex] == 0) {
                            DIS[ney][nex] = DIS[ny][nx]+1;
                        } else {
                            DIS[ney][nex] = Math.min(DIS[ny][nx]+1, DIS[ney][nex]);
                        }
                        MAX_NUM = Math.max(MAX_NUM, DIS[ney][nex]);
                    }
                }
            }
        }
    }
}
