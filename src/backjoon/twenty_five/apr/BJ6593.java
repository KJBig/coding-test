package backjoon.twenty_five.apr;

import java.io.*;
import java.util.*;

public class BJ6593 {

    static int[] DH = {0, 0, 0, 0, 1, -1};
    static int[] DY = {1, 0, -1, 0, 0, 0};
    static int[] DX = {0, 1, 0, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] inputs = br.readLine().split(" ");
            int L = Integer.parseInt(inputs[0]);
            int R = Integer.parseInt(inputs[1]);
            int C = Integer.parseInt(inputs[2]);

            if (L==0 && R==0 && C==0) {
                break;
            }

            String[][][] BOARD = new String[L][R][C];
            boolean[][][] VISITED = new boolean[L][R][C];
            int startL = 0;
            int startR = 0;
            int startC = 0;

            for (int i=0; i<L; i++) {
                for (int j=0; j<R; j++) {
                    String[] boardInputs = br.readLine().split("");
                    for (int k=0; k<C; k++) {
                        BOARD[i][j][k] = boardInputs[k];
                        if (boardInputs[k].equals("S")) {
                            startL = i;
                            startR = j;
                            startC = k;
                        }
                    }
                }
                br.readLine();
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startL, startR, startC, 0});
            VISITED[startL][startR][startC] = true;

            int result = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int h = poll[0];
                int y = poll[1];
                int x = poll[2];
                int count = poll[3];

                for (int i=0; i<6; i++) {
                    int nh = h + DH[i];
                    int ny = y + DY[i];
                    int nx = x + DX[i];

                    if (0<=nh && nh<L && 0<=ny && ny<R && 0<=nx && nx<C) {
                        if (!VISITED[nh][ny][nx]) {
                            if (BOARD[nh][ny][nx].equals(".")) {
                                VISITED[nh][ny][nx] = true;
                                queue.add(new int[]{nh, ny, nx, count+1});
                            } else if (BOARD[nh][ny][nx].equals("E")) {
                                result = Math.min(result, count+1);
                            }
                        }
                    }
                }
            }

            if (result != Integer.MAX_VALUE) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }

        }

    }
}
