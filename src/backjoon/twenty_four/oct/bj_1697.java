package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_1697 {

    static int[] BOARD = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        if (start == end) {
            System.out.println(0);
        } else {
            bfs(start, end);
        }
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int next;
            for (int i=0; i<3; i++) {
                if (i==0) {
                    next = poll+1;
                } else if (i==1) {
                    next = poll-1;
                } else {
                    next = poll*2;
                }

                if (next == end) {
                    System.out.println(BOARD[poll]+1);
                    return;
                }

                if (next >= 0 && next <= 100000 && BOARD[next] == 0) {
                    BOARD[next] = BOARD[poll]+1;
                    queue.add(next);
                }

            }

        }
    }
}


