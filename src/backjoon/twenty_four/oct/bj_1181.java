package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class bj_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, SortedSet<String>> board = new HashMap<>();

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            int strSize = s.length();
            if (!board.containsKey(strSize)) {
                board.put(strSize, new TreeSet<>());
            }
            board.get(strSize).add(s);
        }

        List<Integer> keys = board.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Integer integer : keys) {
            SortedSet<String> strings = board.get(integer);
            for (String string : strings) {
                sb.append(string).append("\n");
            }
        }

        System.out.println(sb);
    }
}
