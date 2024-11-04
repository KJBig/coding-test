package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] board = new int[M];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            board[i] = Integer.parseInt(input[i]);
        }

        int answer = 0;

        for (int index=1; index<M; index++) {
            int left = 0;
            int right = 0;

            for (int i=0; i<index; i++) {
                left = Math.max(left, board[i]);
            }

            for (int j=index+1; j<M; j++) {
                right = Math.max(right, board[j]);
            }

            int minMax = Math.min(left, right);

            if (board[index] < minMax) {
                answer += (minMax - board[index]);
                board[index] = minMax;
            }
        }

        System.out.println(answer);
    }
}
