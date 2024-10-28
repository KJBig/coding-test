package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class bj_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, List<String>> hashMap = new HashMap<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            if (!hashMap.containsKey(age)) {
                hashMap.put(age, new ArrayList<>());
            }
            hashMap.get(age).add(input[1]);
        }

        List<Integer> keys = hashMap.keySet().stream().sorted().collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Integer key : keys) {
            for (String str : hashMap.get(key)) {
                sb.append(key).append(" ").append(str).append("\n");
            }
        }

        System.out.println(sb);
        
    }
}
