package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class BJ5622 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hashMap.put(3, List.of("A", "B", "C"));
        hashMap.put(4, List.of("D", "E", "F"));
        hashMap.put(5, List.of("G", "H", "I"));
        hashMap.put(6, List.of("J", "K", "L"));
        hashMap.put(7, List.of("M", "N", "O"));
        hashMap.put(8, List.of("P", "Q", "R", "S"));
        hashMap.put(9, List.of("T", "U", "V"));
        hashMap.put(10, List.of("W", "X", "Y", "Z"));

        String[] word = br.readLine().split("");
        int answer = 0;
        for (String s : word) {
            for (Integer key : hashMap.keySet()) {
                if (hashMap.get(key).contains(s)) {
                    answer += key;
                }
            }
        }

        System.out.println(answer);
    }
}
