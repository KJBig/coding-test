package backjoon.twenty_five.may;

import java.io.*;
import java.util.*;

public class BJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int c = Integer.parseInt(inputs[3]);

        int[] board = new int[N];
        HashMap<Integer, Integer> indexes = new HashMap<>();
        int maxCount = 0;

        for (int i=0; i<N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = start+k-1;
        if (end >= N) {
            end = end%N;
        }

        if (start < end) {
            for (int i = start; i <= end; i++) {
                if (!indexes.containsKey(board[i])) {
                    indexes.put(board[i], 0);
                }
                indexes.put(board[i], indexes.get(board[i])+1);
            }
        } else {
            for (int i = start; i < N; i++) {
                if (!indexes.containsKey(board[i])) {
                    indexes.put(board[i], 0);
                }
                indexes.put(board[i], indexes.get(board[i])+1);
            }
            for (int i = 0; i <= end; i++) {
                if (!indexes.containsKey(board[i])) {
                    indexes.put(board[i], 0);
                }
                indexes.put(board[i], indexes.get(board[i])+1);indexes.put(board[i], 1);
            }
        }

        int x = 0;
        while (true) {
            int nowCount = getCount(indexes);
            if (!indexes.containsKey(c) || indexes.get(c) == 0) {
                nowCount++;
            }

            maxCount = Math.max(maxCount, nowCount);

            indexes.put(board[start], indexes.get(board[start])-1);
            start++;
            end++;
            if (end >= N) {
                end = end%N;
            }
            if (start >= N) {
                start = start%N;
            }

            if (!indexes.containsKey(board[end])) {
                indexes.put(board[end], 0);
            }
            indexes.put(board[end], indexes.get(board[end])+1);

            if (start == 0) {
                break;
            }

        }


        System.out.println(maxCount);




    }

    private static int getCount(HashMap<Integer, Integer> indexes) {
        int count = 0;

        for (Integer integer : indexes.keySet()) {
            if (indexes.get(integer) >= 1) {
                count++;
            }
        }

        return count;
    }
}
