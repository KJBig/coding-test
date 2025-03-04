package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20125 {

    static String[][] BOARD;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BOARD = new String[N][N];

        for (int i=0; i<N; i++) {
            BOARD[i] = br.readLine().split("");
        }
        int[] head = {-1, -1};
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (BOARD[i][j].equals("*")) {
                    head = new int[]{i, j};
                    break;
                }
            }
            if (head[0] != -1) {
                break;
            }
        }

        int[] hart = new int[]{head[0]+1, head[1]};
        int leftArmSize = getArmSize(hart, -1);
        int rightArmSize = getArmSize(hart, 1);
        int[] middleData = getMiddleSize(hart);
        int leftLegSize = getLegSize(middleData, -1);
        int rightLegSize = getLegSize(middleData, 1);

        System.out.println((hart[0]+1) + " " + (hart[1]+1));
        System.out.println(leftArmSize + " " + rightArmSize + " " + middleData[2] + " " + leftLegSize + " " + rightLegSize);
    }

    private static int getLegSize(int[] middleData, int i) {
        int size = 0;
        int y = middleData[0];
        int x = middleData[1]+i;
        while (true) {
            size++;
            y++;
            if ((0>y || y>=N) || !BOARD[y][x].equals("*")) {
                break;
            }
        }
        return size;
    }

    private static int[] getMiddleSize(int[] hart) {
        int size = 0;
        int y = hart[0]+1;
        int x = hart[1];
        while (true) {
            if ((0>y || y>=N) || !BOARD[y][x].equals("*")) {
                break;
            }
            size++;
            y++;
        }
        return new int[]{y, x, size};
    }

    private static int getArmSize(int[] hart, int i) {
        int size = 0;
        int y = hart[0];
        int x = hart[1]+i;
        while (true) {
            if ((0>x || x>=N) || !BOARD[y][x].equals("*")) {
                break;
            }
            size++;
            x+=i;
        }
        return size;
    }
}
