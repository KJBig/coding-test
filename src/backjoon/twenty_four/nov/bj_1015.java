package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class bj_1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] answer = new int[N];

        List<Integer> sored = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
            sored.add(Integer.parseInt(input[i]));
        }

        sored.sort(Comparator.naturalOrder());

        for (int i=0; i<N; i++) {
            int index = sored.indexOf(numbers[i]);

            answer[i] = index;
            sored.set(index, -1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
