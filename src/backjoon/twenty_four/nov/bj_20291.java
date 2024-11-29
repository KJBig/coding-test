package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class bj_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i=0; i<N; i++) {
            String input = br.readLine().split("\\.")[1];
            if (!hashMap.containsKey(input)) {
                hashMap.put(input, 1);
            } else {
                Integer now = hashMap.get(input);
                hashMap.put(input, now+1);
            }
        }

        List<String> collect = hashMap.keySet().stream().collect(Collectors.toList());
        collect.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();

        for (String s : collect) {
            sb.append(s).append(" ").append(hashMap.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}
