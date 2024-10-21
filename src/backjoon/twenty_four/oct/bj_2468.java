package backjoon.twenty_four.oct;

import java.io.*;
import java.util.*;

public class bj_2468 {

    static int[] TX = {1, 0, -1, 0};
    static int[] TY = {0, -1, 0, 1};
    static int[][] BOARD;
    static int[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];

        for (int row=0; row<N; row++){
            String[] split = br.readLine().split(" ");
            for (int col=0; col<N; col++) {
                BOARD[row][col] = Integer.parseInt(split[col]);
            }
        }
        int MAX_NUM = 0;
        for (int height=0; height<=100; height++) {
            int answer = 0;
            VISITED = new int[N][N];
            for (int row=0; row<N; row++){
                for (int col=0; col<N; col++){
                    if (BOARD[row][col]>height && VISITED[row][col]==0) {
                        bfs(row, col, height, N);
                        answer++;
                    }
                }
            }
            if (answer == 0) {
                break;
            }

            MAX_NUM = Math.max(MAX_NUM, answer);

        }

        System.out.println(MAX_NUM);


    }

    public static void bfs(int row, int col, int height, int N) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(row, col));

        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int x = poll.get(0);
            int y = poll.get(1);

            for (int i=0; i<4; i++) {
                int tRow = x + TX[i];
                int tCol = y + TY[i];
                if (0<=tRow && tRow<N && 0<=tCol && tCol<N) {
                    if (BOARD[tRow][tCol]>height && VISITED[tRow][tCol]==0) {
                        VISITED[tRow][tCol] = 1;
                        queue.add(List.of(tRow, tCol));
                    }
                }
            }
        }
    }
}
