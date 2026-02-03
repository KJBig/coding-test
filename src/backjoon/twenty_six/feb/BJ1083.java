package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());

        for (int i=0; i<N && S>0; i++) {
            int maxIdx = i;
            for (int j=i+1; j<N && j<=i+S; j++) {
                if (numbers[j] > numbers[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int k=maxIdx; k>i; k--) {
                int temp = numbers[k];
                numbers[k] = numbers[k-1];
                numbers[k-1] = temp;
                S--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }
}