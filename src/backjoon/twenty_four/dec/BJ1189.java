package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1189 {

    static String[][] BOARD;
    static int[][] VISITED;
    static int[] TX = {0, 1, 0, -1};
    static int[] TY = {1, 0, -1, 0};
    static int ANSWER = 0;
    static int R = 0;
    static int C = 0;
    static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BOARD = new String[R][C];
        VISITED = new int[R][C];

        for (int i=0; i<R; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<C; j++) {
                BOARD[i][j] = input[j];
            }
        }
        VISITED[R-1][0] = 1;

        dfs(R-1, 0, 1);

        System.out.println(ANSWER);
    }

    private static void dfs(int y, int x, int count) {
        if (y == 0 && x == C - 1 && count == K) {
            ANSWER++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dy = y + TY[i];
            int dx = x + TX[i];
            if (0 <= dy && dy < R && 0 <= dx && dx < C) {
                if (!BOARD[dy][dx].equals("T") && VISITED[dy][dx] == 0) {
                    VISITED[dy][dx] = 1;
                    dfs(dy, dx, count + 1);
                    VISITED[dy][dx] = 0;
                }
            }
        }
    }

}
