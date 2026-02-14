package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ16198 {

    static List<Integer> NUMBERS;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        NUMBERS = new ArrayList<>();

        String[] numberInput = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            NUMBERS.add(Integer.parseInt(numberInput[i]));
        }

        for (int i=1; i<NUMBERS.size()-1; i++) {
            bfs(i, 0);
        }

        System.out.println(MAX);
    }

    private static void bfs(int index, int value) {
        if (NUMBERS.size() == 3) {
            int left = NUMBERS.get(index-1);
            int right = NUMBERS.get(index+1);
            value += left * right;
            MAX = Math.max(MAX, value);
            return;
        }

        int left = NUMBERS.get(index-1);
        int right = NUMBERS.get(index+1);
        Integer remove = NUMBERS.remove(index);
        for (int i=1; i<NUMBERS.size()-1; i++) {
            bfs(i, value + left * right);
        }
        NUMBERS.add(index, remove);
    }

}