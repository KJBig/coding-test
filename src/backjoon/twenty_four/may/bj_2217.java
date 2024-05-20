package backjoon.twenty_four.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class bj_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];

        for (int i=0; i<N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int i=N-1; i>=0; i--) {
            minNum = Math.min(minNum, ropes[i]);
            maxNum = Math.max(maxNum, minNum*(N-i));
        }

        System.out.println(maxNum);

    }
}
