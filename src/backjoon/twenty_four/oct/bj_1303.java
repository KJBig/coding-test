package backjoon.twenty_four.oct;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj_1303 {

    static int[] gy = {0, -1, 0, 1};
    static int[] gx = {1, 0, -1, 0};
    static int N;
    static int M;
    static String[][] BOARD;
    static int[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        BOARD = new String[N][M];
        VISITED = new int[N][M];

        for (int i=0; i<N; i++) {
            String[] boardElements = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = boardElements[j];
            }
        }

        int ourPower = getPower("W");
        int enemyPower = getPower("B");

        System.out.println(ourPower + " " + enemyPower);
    }

    private static int getPower(String flag) {
        int totalPower = 0;
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++){
                if (BOARD[y][x].equals(flag) && VISITED[y][x] == 0) {
                    VISITED[y][x] = 1;
                    int count = bfs(y, x, flag);
                    totalPower += (count * count);
                }
            }
        }
        return totalPower;
    }

    private static int bfs(int y, int x, String flag) {
        int count = 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(y, x));
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int nowY = poll.get(0);
            int nowX = poll.get(1);
            for (int i=0; i<4; i++) {
                int nextY = nowY + gy[i];
                int nextX = nowX + gx[i];
                if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                    if (BOARD[nextY][nextX].equals(flag) && VISITED[nextY][nextX] == 0){
                        count++;
                        VISITED[nextY][nextX] = 1;
                        queue.add(List.of(nextY, nextX));
                    }
                }
            }
        }

        return count;
    }
}
