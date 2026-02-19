package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ2210 {

    static String[][] BOARD = new String[5][5];
    static HashSet<String> RESULT_SET = new HashSet<>();
    static int[] DX = {-1, 1, 0, 0};
    static int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                BOARD[i][j] = st.nextToken();
            }
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                dfs(i, j, 1, BOARD[i][j]);
            }
        }

        System.out.println(RESULT_SET.size());
    }

    static void dfs(int x, int y, int depth, String currentStr) {
        if (depth == 6) {
            RESULT_SET.add(currentStr);
            return;
        }

        for (int i=0; i<4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, depth + 1, currentStr + BOARD[nx][ny]);
            }
        }
    }
}