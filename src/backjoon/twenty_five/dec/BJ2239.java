package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ2239 {
    static int[][] BOARD = new int[9][9];
    static boolean IS_FINISH = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<9; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<9; j++) {
                BOARD[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0);
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                sb.append(BOARD[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        if (y>=8 && x>8) {
            printBoard();
            IS_FINISH = true;
            return;
        }

        if (IS_FINISH) {
            return;
        }

        if (x>8) {
            x = 0;
            y++;
        }

        if (BOARD[y][x] == 0) {
            List<Integer> possibleNumbers = getPossibleNumbers(y, x);
            for (Integer possibleNumber : possibleNumbers) {
                BOARD[y][x] = possibleNumber;
                dfs(y, x+1);
                BOARD[y][x] = 0;
            }
        } else {
            dfs(y, x+1);
        }
    }

    private static List<Integer> getPossibleNumbers(int y, int x) {
        Set<Integer> impossibleNumbers = new HashSet<>();

        for (int i=0; i<9; i++) {
            if (BOARD[y][i] != 0) {
                impossibleNumbers.add(BOARD[y][i]);
            }
        }

        for (int i=0; i<9; i++) {
            if (BOARD[i][x] != 0) {
                impossibleNumbers.add(BOARD[i][x]);
            }
        }

        int areaY = (y/3)*3;
        int areaX = (x/3)*3;
        for (int i=areaY; i<areaY+3; i++) {
            for (int j=areaX; j<areaX+3; j++) {
                if (BOARD[i][j] != 0) {
                    impossibleNumbers.add(BOARD[i][j]);
                }
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=9; i++) {
            if (!impossibleNumbers.contains(i)) {
                numbers.add(i);
            }
        }

        return numbers;
    }
}
