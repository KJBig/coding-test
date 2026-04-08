package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ16928 {

    static int[] MOVE = new int[101];
    static int[] COUNT = new int[101];
    static boolean[] VISITED = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");

        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);

        for (int i=1; i<=100; i++) {
            MOVE[i] = i;
        }

        for (int i=0; i<N+M; i++) {
            String[] ladderInput = br.readLine().split(" ");
            int start = Integer.parseInt(ladderInput[0]);
            int end = Integer.parseInt(ladderInput[1]);
            MOVE[start] = end;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        VISITED[1] = true;
        COUNT[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == 100) {
                System.out.println(COUNT[now]);
                return;
            }

            for (int i=1; i<=6; i++) {
                int next = now + i;

                if (next > 100) {
                    continue;
                }

                int finalNext = MOVE[next];

                if (!VISITED[finalNext]) {
                    VISITED[finalNext] = true;
                    COUNT[finalNext] = COUNT[now]+1;
                    queue.add(finalNext);
                }
            }
        }
    }
}