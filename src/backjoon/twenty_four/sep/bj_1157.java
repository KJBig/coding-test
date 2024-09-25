package backjoon.twenty_four.sep;

import java.io.*;
import java.util.HashMap;

public class bj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<String, Integer> hashMap = new HashMap<>();
        String lowerCase = input.toLowerCase();
        for (int i=0; i<input.length(); i++) {
            String now = lowerCase.substring(i, i + 1);
            if (!hashMap.containsKey(now)){
                hashMap.put(now, 1);
            }
            hashMap.put(now, hashMap.get(now)+1);
        }

        String answer = null;
        int maxNum = 0;
        boolean isSame = false;
        for (String key : hashMap.keySet()) {
            if (maxNum < hashMap.get(key)) {
                maxNum = hashMap.get(key);
                answer = key;
                isSame = false;
            }

            if (!answer.equals(key) && maxNum == hashMap.get(key)) {
                isSame = true;
            }
        }

        if (isSame) {
            answer = "?";
        }

        System.out.println(answer.toUpperCase());
    }
}
