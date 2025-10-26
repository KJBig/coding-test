 package backjoon.twenty_five.oct;

import java.io.*;
import java.util.*;

public class BJ2251 {
    static int[] SIZES = new int[3];
    static boolean[][] VISITED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        SIZES[0] = Integer.parseInt(input[0]);
        SIZES[1] = Integer.parseInt(input[1]);
        SIZES[2] = Integer.parseInt(input[2]);

        VISITED = new boolean[SIZES[0]+1][SIZES[1]+1];

        TreeSet<Integer> answers = new TreeSet<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, SIZES[2]});
        VISITED[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (a == 0) {
                answers.add(c);
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue;
                    }

                    int[] next = cur.clone();
                    if (next[from] == 0 || next[to] == SIZES[to]) {
                        continue;
                    }

                    int movable = Math.min(next[from], SIZES[to] - next[to]);
                    if (movable == 0) {
                        continue;
                    }

                    next[from] -= movable;
                    next[to] += movable;

                    int na = next[0];
                    int nb = next[1];
                    if (!VISITED[na][nb]) {
                        VISITED[na][nb] = true;
                        queue.add(next);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : answers) sb.append(val).append(' ');
        System.out.println(sb.toString().trim());
    }
}
