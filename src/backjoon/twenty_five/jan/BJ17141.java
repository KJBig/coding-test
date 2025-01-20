package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ17141 {
    static int N, M;
    static int EMPTY = 0;
    static int[][] BOARD;
    static List<int[]> VIRUS = new ArrayList<>();
    static List<int[]> ABLE_VIRUS = new ArrayList<>();
    static int[][] VIRUS_LOCATION;
    static int[][] VISITED;
    static int MIN_TIME = Integer.MAX_VALUE;

    static int[] DY = {1, 0, -1, 0};
    static int[] DX = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        BOARD = new int[N][N];

        // 보드 초기화 && 바이러스 둘 수 있는 곳 체크 && 채워야할 곳 수
        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                int now = Integer.parseInt(boardInput[j]);
                BOARD[i][j] = now;
                if (now == 2) {
                    ABLE_VIRUS.add(new int[]{i, j});
                }
                if (now != 1) {
                    EMPTY++;
                }
            }
        }
        EMPTY -= M;

        VIRUS_LOCATION = new int[N][N];
        pickLocation(0, 0);

        if (MIN_TIME == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN_TIME);
        }

    }

    private static void pickLocation(int start, int count) {
        if (count == M) {
            int answer = processContagion();
            if (answer != -1) {
                MIN_TIME = Math.min(MIN_TIME, answer-1);
            }
            return;
        }

        for (int i=start; i<ABLE_VIRUS.size(); i++) {
            int[] ints = ABLE_VIRUS.get(i);
            int y = ints[0];
            int x = ints[1];
            if (VIRUS_LOCATION[y][x] == 0) {
                VIRUS_LOCATION[y][x] = 1;
                VIRUS.add(new int[]{y, x});
                pickLocation(i+1, count+1);
                VIRUS.remove(VIRUS.size()-1);
                VIRUS_LOCATION[y][x] = 0;
            }
        }
    }

    private static int processContagion() {
        int answer = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        VISITED = new int[N][N];
        for (int[] virus : VIRUS) {
            queue.add(new int[]{virus[0], virus[1]});
            VISITED[virus[0]][virus[1]] = 1;
        }

        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            Queue<int[]> subQueue = new LinkedList<>();
            for (int i=0; i<size; i++) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];
                for (int j=0; j<4; j++) {
                    int ty = y + DY[j];
                    int tx = x + DX[j];
                    if (0<=ty && ty<N && 0<=tx && tx<N) {
                        if (BOARD[ty][tx] != 1 && VISITED[ty][tx] == 0) {
                            subQueue.add(new int[]{ty, tx});
                            VISITED[ty][tx] = 1;
                            count++;
                        }
                    }
                }
            }

            queue.addAll(subQueue);

        }

        return count == EMPTY ? answer : -1;

    }
}
