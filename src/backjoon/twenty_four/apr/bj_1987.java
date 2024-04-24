package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bj_1987 {
    static int R;
    static int C;
    static String[][] BOARD;
    static int[] tx = {0, 1, 0, -1};
    static int[] ty = {1, 0, -1, 0};
    static int MAX_COUNT = 0;

    static HashMap<String, Integer> VISITED = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        BOARD = new String[R][C];

        for (char c = 'A'; c <= 'Z'; c++) {
            String key = String.valueOf(c);
            VISITED.put(key, 0);
        }

        for (int i=0; i<R; i++) {
            String[] split = br.readLine().split("");
            BOARD[i] = split;
        }
        List<String> list = new ArrayList<>();
        list.add(BOARD[0][0]);
        VISITED.put(BOARD[0][0], 1);
        bfs(0, 0, list, 1);

        System.out.println(MAX_COUNT);
    }

    public static int bfs(int y, int x, List<String> list, int count) {
        for (int i=0; i<4; i++) {
            int zy = y + ty[i];
            int zx = x + tx[i];
            if (zy>=0 && zy<R && zx>=0 && zx<C) {
                if(VISITED.get(BOARD[zy][zx]) == 0) {
                    list.add(BOARD[zy][zx]);
                    count++;
                    VISITED.put(BOARD[zy][zx], 1);
                    bfs(zy, zx, list, count);
                    list.remove(list.size() - 1);
                    VISITED.put(BOARD[zy][zx], 0);
                    count--;
                }
            }
        }
        MAX_COUNT = Math.max(MAX_COUNT, count);

        return 0;
    }

}