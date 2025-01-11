package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4179 {
    static String[][] BOARD;
    static int R, C;
    static int[] JIHUN;
    static List<int[]> FIRES = new ArrayList<>();
    static int[][] FIRE_TIME;
    static int[][] JIHUN_TIME;
    static int[] TX = {0, 1, 0, -1};
    static int[] TY = {1, 0, -1, 0};
    static int MIN_TIME = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");
        R = Integer.parseInt(sizeInput[0]);
        C = Integer.parseInt(sizeInput[1]);
        BOARD = new String[R][C];
        FIRE_TIME = new int[R][C];
        JIHUN_TIME = new int[R][C];

        for (int i=0; i<R; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<C; j++) {
                BOARD[i][j] = split[j];
                if (split[j].equals("J")) {
                    JIHUN = new int[]{i ,j};
                    JIHUN_TIME[i][j] = 1;
                }
                if (split[j].equals("F")) {
                    FIRES.add(new int[]{i ,j});
                    FIRE_TIME[i][j] = 1;
                }
            }
        }

        for (int[] fire : FIRES) {
            setFireTime(fire);
        }

        processJihun(JIHUN);

        if (MIN_TIME == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(MIN_TIME);
        }


    }

    private static void processJihun(int[] jihun) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(jihun);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i=0; i<4; i++) {
                int ny = y + TY[i];
                int nx = x + TX[i];
                if (0>ny || ny>=R || 0>nx || nx>=C) {
                    MIN_TIME = Math.min(MIN_TIME, JIHUN_TIME[y][x]);
                }

                if (0<=ny && ny<R && 0<=nx && nx<C && !BOARD[ny][nx].equals("#")) {
                    if((FIRE_TIME[ny][nx] > JIHUN_TIME[y][x]+1) || FIRE_TIME[ny][nx] == 0) {
                        if (JIHUN_TIME[ny][nx] == 0) {
                            JIHUN_TIME[ny][nx] = JIHUN_TIME[y][x]+1;
                            queue.add(new int[]{ny, nx});
                        } else {
                            JIHUN_TIME[ny][nx] = Math.min(JIHUN_TIME[ny][nx], JIHUN_TIME[y][x]+1);
                        }
                    }
                }

            }
        }
    }

    private static void setFireTime(int[] fire) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(fire);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++) {
                int ny = y + TY[i];
                int nx = x + TX[i];
                if (0<=ny && ny<R && 0<=nx && nx<C && !BOARD[ny][nx].equals("#")) {
                    if (FIRE_TIME[ny][nx] == 0) {
                        FIRE_TIME[ny][nx] = FIRE_TIME[y][x]+1;
                        queue.add(new int[]{ny, nx});
                    } else {
                        if (FIRE_TIME[ny][nx] > FIRE_TIME[y][x]+1) {
                            FIRE_TIME[ny][nx] = FIRE_TIME[y][x]+1;
                            queue.add(new int[]{ny, nx});
                        }

                    }
                }
            }
        }
    }
}
