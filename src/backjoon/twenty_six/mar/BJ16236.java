package backjoon.twenty_six.mar;

import java.io.*;
import java.util.*;

public class BJ16236 {

    static int N, SHARK_Y, SHARK_X, SHARK_SIZE;
    static int[][] BOARD;

    static int[] DY = {1, 0, 0, -1};
    static int[] DX = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BOARD = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
                if (BOARD[i][j] == 9) {
                    SHARK_Y = i;
                    SHARK_X = j;
                    BOARD[i][j] = 0;
                }
            }
        }

        SHARK_SIZE = 2;
        int totalTime = 0;
        int eatenCount = 0;
        while (true) {
            Fish target = findFish();

            if (target == null) {
                break;
            }

            // 물고기 먹기
            totalTime += target.distance;
            SHARK_Y = target.y;
            SHARK_X = target.x;
            BOARD[SHARK_Y][SHARK_X] = 0;
            eatenCount++;

            // 상어 크기 증가
            if (eatenCount == SHARK_SIZE) {
                SHARK_SIZE++;
                eatenCount = 0;
            }
        }

        System.out.println(totalTime);
    }

    static Fish findFish() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        List<Fish> fishes = new ArrayList<>();

        queue.add(new int[]{SHARK_Y, SHARK_X, 0});
        visited[SHARK_Y][SHARK_X] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int dist = poll[2];

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny>=0 && ny<N && nx>=0 && nx<N && !visited[ny][nx]) {
                    if (BOARD[ny][nx] <= SHARK_SIZE) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx, dist + 1});

                        if (BOARD[ny][nx] > 0 && BOARD[ny][nx] < SHARK_SIZE) {
                            fishes.add(new Fish(ny, nx, dist + 1));
                        }
                    }
                }
            }
        }

        if (fishes.isEmpty()) {
            return null;
        }

        Collections.sort(fishes, Comparator.comparingInt((Fish f) -> f.distance)
                .thenComparingInt(f -> f.y)
                .thenComparingInt(f -> f.x)
        );

        return fishes.get(0);
    }

    static class Fish {
        int y;
        int x;
        int distance;

        public Fish(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
