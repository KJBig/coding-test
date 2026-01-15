package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16946 {

    static int N, M;
    static int[][] BOARD;
    static int[][] VISITED;
    static List<int[]> WALLS = new ArrayList<>();
    static int[] GROUP_SIZES;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new int[N][M];
        VISITED = new int[N][M];
        GROUP_SIZES = new int[N * M + 1];

        for (int i=0; i<N; i++) {
            String boardInput = br.readLine();
            for (int j=0; j<M; j++) {
                BOARD[i][j] = boardInput.charAt(j) - '0';
                if (BOARD[i][j] == 1) {
                    WALLS.add(new int[]{i, j});
                }
            }
        }

        // 1. 땅을 돌면서 크기 구하기
        int sizeIndex = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (BOARD[i][j] == 0 && VISITED[i][j] == 0) {
                    checkLandSize(i, j ,sizeIndex);
                    sizeIndex++;
                }
            }
        }

        // 2. 벽을 돌면서 주변 땅의 크기를 합치기
        for (int[] wall : WALLS) {
            int canGoSize = 1;
            int y = wall[0];
            int x = wall[1];
            Set<Integer> adjLandIndex = new HashSet<>();

            for (int i=0; i<4; i++) {
                int nextY = y + DY[i];
                int nextX = x + DX[i];
                if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                    continue;
                }

                if (VISITED[nextY][nextX] != 0) {
                    adjLandIndex.add(VISITED[nextY][nextX]);
                }
            }

            for (Integer landIndex : adjLandIndex) {
                canGoSize += GROUP_SIZES[landIndex];
            }

            BOARD[y][x] = canGoSize%10;
        }

        // 3. 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int[] row : BOARD) {
            for (int col : row) {
                sb.append(col);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void checkLandSize(int y, int x, int sizeIndex) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        VISITED[y][x] = sizeIndex;

        int landSize = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            for (int i=0; i<4; i++) {
                int nextY = nowY + DY[i];
                int nextX = nowX + DX[i];

                if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                    continue;
                }

                if (BOARD[nextY][nextX] == 0 && VISITED[nextY][nextX] == 0) {
                    VISITED[nextY][nextX] = sizeIndex;
                    landSize++;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }

        GROUP_SIZES[sizeIndex] = landSize;
    }
}
