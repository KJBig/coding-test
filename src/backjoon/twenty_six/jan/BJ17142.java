package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ17142 {

    static int N, M;
    static int[][] BOARD;
    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};

    static List<int[]> VIRUS_LOCATION = new ArrayList<>();
    static int EMPTY_COUNT = 0;

    static int MIN_TIME = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        M = Integer.parseInt(initInput[1]);

        BOARD = new int[N][N];

        for (int i=0; i<N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                BOARD[i][j] = Integer.parseInt(row[j]);
                if (BOARD[i][j] == 2) {
                    VIRUS_LOCATION.add(new int[]{i, j});
                } else if (BOARD[i][j] == 0) {
                    EMPTY_COUNT++;
                }
            }
        }

        if (EMPTY_COUNT == 0) {
            System.out.println(0);
            return;
        }

        selectVirus(0, new ArrayList<>());

        System.out.println(MIN_TIME == Integer.MAX_VALUE ? -1 : MIN_TIME);
    }

    private static void selectVirus(int start, List<int[]> picked) {
        if (picked.size() == M) {
            int time = calTime(picked);
            MIN_TIME = Math.min(MIN_TIME, time);
            return;
        }

        if (MIN_TIME == 0) {
            return;
        }

        for (int i=start; i<VIRUS_LOCATION.size(); i++) {
            picked.add(VIRUS_LOCATION.get(i));
            selectVirus(i + 1, picked);
            picked.remove(picked.size() - 1);
        }
    }

    private static int calTime(List<int[]> active) {
        int[][] dist = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] v : active) {
            dist[v[0]][v[1]] = 0;
            queue.add(v);
        }

        int remainEmpty = EMPTY_COUNT;
        int maxTime = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            if (dist[y][x] >= MIN_TIME) {
                continue;
            }

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny<0 || ny>=N || nx<0 || nx>=N) {
                    continue;
                }
                if (BOARD[ny][nx] == 1) {
                    continue;
                }
                if (dist[ny][nx] != -1) {
                    continue;
                }

                dist[ny][nx] = dist[y][x] + 1;
                queue.add(new int[]{ny, nx});

                if (BOARD[ny][nx] == 0) {
                    remainEmpty--;
                    maxTime = Math.max(maxTime, dist[ny][nx]);

                    if (remainEmpty == 0) {
                        return maxTime;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
