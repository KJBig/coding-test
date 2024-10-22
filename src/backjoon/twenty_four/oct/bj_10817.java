package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        List<Integer> ary = new ArrayList<>();

        for (String s : split) {
            ary.add(Integer.parseInt(s));
        }
        ary.sort(Comparator.reverseOrder());

        System.out.println(ary.get(1));
    }
}
