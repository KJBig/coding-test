package backjoon.twenty_five.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ17090 {
    static int N, M;
    static int ANSWER = 0;
    static String[][] BOARD;
    static int[][] STATE;
    static int[][] VISITED;
    static HashMap<String, int[]> DIRECTION = new HashMap<>();

    public static void main(String[] args) throws IOException {
        initDirection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        BOARD = new String[N][M];
        STATE = new int[N][M];
        VISITED = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = split[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (STATE[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(ANSWER);

    }

    private static void initDirection() {
        DIRECTION.put("U", new int[]{-1, 0});
        DIRECTION.put("R", new int[]{0, 1});
        DIRECTION.put("D", new int[]{1, 0});
        DIRECTION.put("L", new int[]{0, -1});
    }

    private static int dfs(int i, int j) {
        if (0>i || i>=N || 0>j || j>=M) {
            return 1;
        }

        if (VISITED[i][j] == 1) {
            if (STATE[i][j] != 0) {
                return STATE[i][j];
            } else {
                return 2;
            }

        }

        VISITED[i][j] = 1;
        int[] direct = DIRECTION.get(BOARD[i][j]);
        STATE[i][j] = dfs(i+direct[0], j+direct[1]);
        if (STATE[i][j] == 1) {
            ANSWER++;
        }
        return STATE[i][j];
    }

}
