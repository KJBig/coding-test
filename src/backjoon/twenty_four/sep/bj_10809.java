package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] split = br.readLine().split("");

        for (int i=65; i<=90; i++) {
            String alp = String.valueOf((char) Character.toLowerCase(i));
            hashMap.put(alp, -1);
        }

        for (int i=0; i<split.length; i++) {
            if (hashMap.get(split[i]) == -1){
                hashMap.put(split[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (String key : hashMap.keySet()) {
            sb.append(hashMap.get(key)).append(" ");
        }
        System.out.println(sb);
    }
}
