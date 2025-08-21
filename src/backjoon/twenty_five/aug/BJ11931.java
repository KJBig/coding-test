package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] numbers = new Integer[N];
        
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
        }

        Arrays.sort(numbers, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            sb.append(numbers[i]).append("\n");
        }

        System.out.println(sb);

    }
}
