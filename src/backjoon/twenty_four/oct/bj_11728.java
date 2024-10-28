package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class bj_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = br.readLine().split(" ");
        int aSize = Integer.parseInt(sizes[0]);
        int bSize = Integer.parseInt(sizes[1]);
        List<Integer> answer = new ArrayList<>();


        String[] aNumbers = br.readLine().split(" ");
        for (int i=0; i<aSize; i++) {
            answer.add(Integer.parseInt(aNumbers[i]));
        }

        String[] bNumbers = br.readLine().split(" ");
        for (int i=0; i<bSize; i++) {
            answer.add(Integer.parseInt(bNumbers[i]));
        }

        answer.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer integer : answer) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);

    }

}
