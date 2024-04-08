package backjoon.twenty_four.mar;

import java.io.*;
import java.util.*;

public class bj_2667 {
    private static int[][] BOARD;
    private static int[][] VISITED;
    private static int[] MX = {0, 1, 0, -1};
    private static int[] MY = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];
        VISITED = new int[N][N];

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<N; j++) {
                BOARD[i][j] = Integer.parseInt(split[j]);
            }
        }

        int number = 0;
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (BOARD[i][j] == 1 && VISITED[i][j] == 0) {
                    VISITED[i][j] = 1;
                    int count = bfs(i, j, N);
                    number++;
                    result.add(count);
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        System.out.println(number);
        for (Integer num : result) {
            System.out.println(num);
        }

    }

    private static int bfs(int y, int x, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int ny = poll[0];
            int nx = poll[1];

            for (int i=0; i<4; i++) {
                int ty = ny + MY[i];
                int tx = nx + MX[i];

                    if (ty>=0 && ty<N && tx>=0 && tx<N && BOARD[ty][tx] == 1 && VISITED[ty][tx] == 0) {
                    queue.offer(new int[]{ty, tx});
                    VISITED[ty][tx] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}
