package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj_1759 {
    static int L;
    static int C;
    static String[] BOARD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        BOARD = br.readLine().split(" ");
        Arrays.sort(BOARD);

        bfs(0, 0, new ArrayList<>());

    }

    public static int bfs(int start, int size, List<String> list) {
        if (size == L) {
            if (isContain(list)) {
                printList(list);
            }
            return 0;
        }

        for (int i=start; i<C; i++) {
            list.add(BOARD[i]);
            bfs(i + 1, size + 1, list);
            list.remove(list.size() - 1);
        }
        return 0;
    }

    private static boolean isContain(List<String> list) {
        List<String> mo = List.of("a", "e", "i", "o", "u");
        int moCount = 0;
        int jaCount = 0;

        for (String s : list) {
            if (mo.contains(s)){
                moCount++;
            } else {
                jaCount++;
            }
        }

        return moCount >= 1 && jaCount >= 2;
    }

    private static void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str);
        }
        System.out.println();
    }
}