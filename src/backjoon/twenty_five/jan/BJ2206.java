package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2206 {
    static int N;
    static int M;
    static int[][] BOARD;
    static int[][][] VISITED;

    static int[] TX = {0, 1, 0, -1};
    static int[] TY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        BOARD = new int[N][M];
        VISITED = new int[2][N][M];

        for (int i=0; i<N; i++) {
            String[] numberInput = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(numberInput[j]);
            }
        }

        bfs(0,0);

        if (VISITED[0][N-1][M-1] == 0 && VISITED[1][N-1][M-1] == 0) {
            System.out.println(-1);
        } else {
            if (VISITED[0][N - 1][M - 1] == 0) {
                System.out.println(VISITED[1][N-1][M-1]);
            } else if (VISITED[1][N-1][M-1] == 0) {
                System.out.println(VISITED[0][N-1][M-1]);
            } else {
                System.out.println(Math.min(VISITED[0][N - 1][M - 1], VISITED[1][N-1][M-1]));
            }
        }

    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        VISITED[0][y][x] = 1;
        queue.add(new int[]{y, x, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ny = poll[0];
            int nx = poll[1];
            int crashStatus = poll[2];

            for (int i=0; i<4; i++) {
                int dy = ny + TY[i];
                int dx = nx + TX[i];
                if (0<=dy && dy<N && 0<=dx && dx<M) {
                    if (crashStatus == 0) {
                        if (BOARD[dy][dx] == 0) {
                            setVISITED(queue, crashStatus, dy, dx, crashStatus, ny, nx);
                        } else {
                            setVISITED(queue, crashStatus+1, dy, dx, crashStatus, ny,nx);
                        }
                    } else {
                        if (BOARD[dy][dx] == 0) {
                            setVISITED(queue, crashStatus, dy, dx, crashStatus, ny,nx);
                        }
                    }
                }
            }
        }
    }

    private static void setVISITED(Queue<int[]> queue, int crashStatus, int dy, int dx, int crashStatus1, int ny, int nx) {
        if (VISITED[crashStatus][dy][dx] == 0) {
            VISITED[crashStatus][dy][dx] = VISITED[crashStatus1][ny][nx] +1;
            queue.add(new int[]{dy, dx, crashStatus});
        } else  {
            if (VISITED[crashStatus][dy][dx] > VISITED[crashStatus1][ny][nx] +1) {
                VISITED[crashStatus][dy][dx] = VISITED[crashStatus1][ny][nx] +1;
                queue.add(new int[]{dy, dx, crashStatus});
            }
        }
    }
}
