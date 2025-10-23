package backjoon.twenty_five.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2665 {
    static int[][] BOARD;
    static VisitData[][] VISITED;
    static int N;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];
        VISITED = new VisitData[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                VISITED[i][j] = new VisitData();
            }
        }

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<N; j++) {
                BOARD[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
        System.out.println(VISITED[N-1][N-1].turn);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        VISITED[0][0].isVisited = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];
                int nowDelete = poll[2];

                if (0<=ny && ny<N && 0<=nx && nx<N) {
                    if (BOARD[ny][nx] != 1) {
                        nowDelete++;
                    }
                    if (VISITED[ny][nx].isVisited==false) {
                        queue.add(new int[]{ny, nx, nowDelete});
                        VISITED[ny][nx].isVisited = true;
                        VISITED[ny][nx].turn = nowDelete;
                    } else {
                        if (VISITED[ny][nx].turn > nowDelete) {
                            queue.add(new int[]{ny, nx, nowDelete});
                            VISITED[ny][nx].turn = nowDelete;
                        }
                    }
                }
            }
        }
    }

    static class VisitData {
        int turn;
        boolean isVisited;

        public VisitData(){
            this.turn=0;
            this.isVisited=false;
        }
    }
}
