package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] values = new int[N];
        int[] score = new int[N];

        for (int i=0; i<N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[] reverseValues = new int[1_000_001];

        for (int i=0; i<N; i++) {
            int nowNumber = values[i];
            reverseValues[nowNumber] = i+1;
        }
        for (int i=0; i<N; i++) {
            int nowNumber = values[i];
            for (int j=nowNumber*2; j<reverseValues.length; j+=nowNumber) {
                if (reverseValues[j] != 0) {
                    score[i]++;
                    score[reverseValues[j]-1]--;
                }
            }
        }

        for (int i : score) {
            System.out.print(i + " ");
        }

    }

}
