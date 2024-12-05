package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashMap<String, Double> hashMap = new HashMap<>();
        hashMap.put("A+", 4.3);
        hashMap.put("A0", 4.0);
        hashMap.put("A-", 3.7);
        hashMap.put("B+", 3.3);
        hashMap.put("B0", 3.0);
        hashMap.put("B-", 2.7);
        hashMap.put("C+", 2.3);
        hashMap.put("C0", 2.0);
        hashMap.put("C-", 1.7);
        hashMap.put("D+", 1.3);
        hashMap.put("D0", 1.0);
        hashMap.put("D-", 0.7);
        hashMap.put("F", 0.0);

        System.out.println(hashMap.get(s));

    }
}
