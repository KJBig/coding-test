package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj_7569 {

    static int[] NEXT_X = {1, 0, -1, 0, 0, 0};
    static int[] NEXT_Y = {0, -1, 0, 1, 0, 0};
    static int[] NEXT_Z = {0, 0, 0, 0, 1, -1};

    static int M;
    static int N;
    static int H;

    static List<List<List<Integer>>> BOARD = new ArrayList<>();
    static List<List<List<Boolean>>> VISITED = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<List<Integer>> queue = new LinkedList<>();
        int days = 0;
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        H = Integer.parseInt(inputs[2]);

        // BOARD Init
        for (int hi=0; hi<H; hi++) {
            List<List<Integer>> flows = new ArrayList<>();
            List<List<Boolean>> flowVisited = new ArrayList<>();
            for (int ni=0; ni<N; ni++) {
                String[] split = br.readLine().split(" ");
                List<Integer> lines = new ArrayList<>();
                List<Boolean> lineVisited = new ArrayList<>();
                for (int mi=0; mi<M; mi++) {
                    lines.add(Integer.parseInt(split[mi]));
                    lineVisited.add(false);
                }
                flows.add(lines);
                flowVisited.add(lineVisited);
            }
            BOARD.add(flows);
            VISITED.add(flowVisited);
        }

        for (int z=0; z<H; z++) {
            for (int y=0; y<N; y++) {
                for (int x=0; x<M; x++) {
                    if (!VISITED.get(z).get(y).get(x) && BOARD.get(z).get(y).get(x) == 1) {
                        queue.add(List.of(z, y, x));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            queue = bfs(queue);
            days++;
        }
        days--;
        if (!isAllSuccess()) {
            days = -1;
        }
        System.out.println(days);
    }

    private static boolean isAllSuccess() {
        for (int z=0; z<H; z++) {
            for (int y=0; y<N; y++) {
                for (int x=0; x<M; x++) {
                    if (BOARD.get(z).get(y).get(x) != -1 && BOARD.get(z).get(y).get(x) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static Queue<List<Integer>> bfs(Queue<List<Integer>> oldQueue) {
        Queue<List<Integer>> queue = new LinkedList<>();


        while (!oldQueue.isEmpty()) {
            List<Integer> poll = oldQueue.poll();
            int nowZ = poll.get(0);
            int nowY = poll.get(1);
            int nowX = poll.get(2);

            for (int i=0; i<6; i++) {
                int tz = nowZ + NEXT_Z[i];
                int ty = nowY + NEXT_X[i];
                int tx = nowX + NEXT_Y[i];
                if (0 <= tz && tz < H && 0 <= ty && ty < N && 0 <= tx && tx < M) {
                    if (!VISITED.get(tz).get(ty).get(tx) && BOARD.get(tz).get(ty).get(tx) == 0) {
                        BOARD.get(tz).get(ty).set(tx, 1);
                        VISITED.get(tz).get(ty).set(tx, true);
                        queue.add(List.of(tz, ty, tx));
                    }
                }

            }
        }
        return queue;
    }
}
