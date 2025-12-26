package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ18405 {

    static int N, K;
    static int[][] BOARD;
    static int[] DX = {0, 1, 0, -1};
    static int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BOARD = new int[N][N];

        List<Virus> init = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = Integer.parseInt(st.nextToken());
                if (BOARD[i][j] != 0) {
                    init.add(new Virus(BOARD[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        init.sort(Comparator.comparingInt(v -> v.type));

        Queue<Virus> q = new ArrayDeque<>();
        for (Virus v : init) {
            q.add(v);
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            if (cur.time == S) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + DY[d];
                int nx = cur.x + DX[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                if (BOARD[ny][nx] == 0) {
                    BOARD[ny][nx] = cur.type;
                    q.add(new Virus(cur.type, ny, nx, cur.time + 1));
                }
            }
        }

        System.out.println(BOARD[X][Y]);
    }

    static class Virus {
        int type, y, x, time;
        Virus(int type, int y, int x, int time) {
            this.type = type;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}