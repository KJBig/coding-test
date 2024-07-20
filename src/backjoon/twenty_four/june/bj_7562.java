package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj_7562 {
    static int[][] BOARD;
    static int[][] VISITED;
    static int[] ny = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] nx = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int I = Integer.parseInt(br.readLine());
            BOARD = new int[I][I];
            VISITED = new int[I][I];
            String[] split = br.readLine().split(" ");
            String[] split1 = br.readLine().split(" ");
            int[] target = new int[]{Integer.parseInt(split1[0]), Integer.parseInt(split1[1])};

            bfs(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

            System.out.println(BOARD[target[0]][target[1]]);
        }
    }

    private static void bfs(int nowY, int nowX) {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> list = List.of(nowY, nowX);
        queue.add(list);

        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int y = poll.get(0);
            int x = poll.get(1);
            VISITED[y][x] = 1;

            for (int i=0; i<8; i++) {
                int ty = y + ny[i];
                int tx = x + nx[i];

                if (ty>=0 && ty<BOARD.length && tx>=0 && tx<BOARD.length && VISITED[ty][tx] == 0) {
                    BOARD[ty][tx] = BOARD[y][x] + 1;
                    queue.add(List.of(ty, tx));
                    VISITED[ty][tx] = 1;
                }
            }

        }
    }

}
