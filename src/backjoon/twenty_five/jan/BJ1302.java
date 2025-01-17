package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            if (hashMap.containsKey(input)) {
                hashMap.put(input, hashMap.get(input)+1);
            } else {
                hashMap.put(input, 1);
            }
        }

        int maxCount = 0;
        String maxStr = "";
        for (String s : hashMap.keySet()) {
            if (maxCount < hashMap.get(s)) {
                maxCount = hashMap.get(s);
                maxStr = s;
            } else if (maxCount == hashMap.get(s)) {
                List<String> strs = new ArrayList<>();
                strs.add(maxStr);
                strs.add(s);
                Collections.sort(strs);
                maxStr = strs.get(0);
            }
        }

        System.out.println(maxStr);

    }
}
