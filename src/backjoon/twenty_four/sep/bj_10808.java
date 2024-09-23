package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class bj_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] split = br.readLine().split("");

        for (int i=65; i<=90; i++) {
            String alp = String.valueOf((char) Character.toLowerCase(i));
            hashMap.put(alp, 0);
        }

        for (int i=0; i<split.length; i++) {
            hashMap.put(split[i], hashMap.get(split[i])+1);
        }
        StringBuilder sb = new StringBuilder();

        for (String key : hashMap.keySet()) {
            sb.append(hashMap.get(key)).append(" ");
        }
        System.out.println(sb);
    }
}
