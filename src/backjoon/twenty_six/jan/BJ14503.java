package backjoon.twenty_six.jan;

import java.io.*;

public class BJ14503 {

    static int[] DY = {-1, 0, 1, 0};
    static int[] DX = {0, 1, 0, -1};
    
    static int N, M;
    static int CLEAN_COUNT = 0;
    static int[][] BOARD;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = br.readLine().split(" ");

        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);

        BOARD = new int[N][M];
        VISITED = new boolean[N][M];

        String[] initInput = br.readLine().split(" ");
        int initY = Integer.parseInt(initInput[0]);
        int initX = Integer.parseInt(initInput[1]);
        int initDirection = Integer.parseInt(initInput[2]);

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        Machine machine = new Machine(initY, initX, initDirection);


        while (true) {
            if (!VISITED[machine.y][machine.x]) {
                VISITED[machine.y][machine.x] = true;
                CLEAN_COUNT++;
            }

            if (checkAroundDirty(machine.y, machine.x)) {
                boolean isMoved = moveAround(machine);
                if (isMoved) {
                    continue;
                }
            }
            
            if (!canBack(machine)) {
                break;
            }

            moveBack(machine);
        }

        System.out.println(CLEAN_COUNT);
        
    }

    private static void moveBack(Machine machine) {
        machine.y -= DY[machine.direction];
        machine.x -= DX[machine.direction];
    }

    private static boolean canBack(Machine machine) {
        int nextY = machine.y - DY[machine.direction];
        int nextX = machine.x - DX[machine.direction];

        if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
            return false;
        }

        if (BOARD[nextY][nextX] == 1) {
            return false;
        }

        return true;
    }

    private static boolean moveAround(Machine machine) {
        for (int i=0; i<4; i++) {
            machine.direction = (machine.direction + 3) % 4;

            int nextY = machine.y + DY[machine.direction];
            int nextX = machine.x + DX[machine.direction];

            if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                continue;
            }

            if (BOARD[nextY][nextX] == 1 || VISITED[nextY][nextX]) {
                continue;
            }

            machine.y = nextY;
            machine.x = nextX;
            return true;
        }

        return false;
    }

    private static boolean checkAroundDirty(int y, int x) {
        for (int i=0; i<4; i++) {
            int nextY = y + DY[i];
            int nextX = x + DX[i];
            
            if (nextY<0 || N<=nextY || nextX<0 || M<=nextX) {
                continue;
            }
            
            if (BOARD[nextY][nextX] == 1 || VISITED[nextY][nextX]) {
                continue;
            }
            
            return true;
        }
        return false;
    }

    static class Machine {
        int y;
        int x;
        int direction;

        public Machine(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }
}
