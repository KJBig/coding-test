package backjoon.twenty_six.mar;

import java.io.*;
import java.util.*;

public class BJ14226 {
    static int S;
    static boolean[][] VISITED = new boolean[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0});
        VISITED[1][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int count = poll[0];
            int board = poll[1];
            int time = poll[2];

            if (count == S) {
                return time;
            }

            if (!VISITED[count][count]) {
                VISITED[count][count] = true;
                queue.add(new int[]{count, count, time+1});
            }

            if (board > 0 && count+board <= 1000) {
                if (!VISITED[count+board][board]) {
                    VISITED[count+board][board] = true;
                    queue.add(new int[]{count+board, board, time+1});
                }
            }

            if (count > 0 && !VISITED[count-1][board]) {
                VISITED[count-1][board] = true;
                queue.add(new int[]{count-1, board, time+1});
            }
        }
        return -1;
    }
}