package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int answer = 0;
        initHashMap(hashMap);
        answer++;

        for (int i=0; i<N.length; i++) {
            int now = Integer.parseInt(N[i]);
            if (now == 9) {
                now = 6;
            }
            Integer restCount = hashMap.get(now);

            if (restCount == 0) {
                plusEachCount(hashMap);
                answer++;
            }
            hashMap.put(now, hashMap.get(now)-1);

        }

        System.out.println(answer);
    }

    private static void initHashMap(HashMap<Integer, Integer> hashMap) {
        for (int i=0; i<9; i++) {
            hashMap.put(i, 1);
            if (i == 6) {
                hashMap.put(i, hashMap.get(i)+1);
            }
        }
    }

    private static void plusEachCount(HashMap<Integer, Integer> hashMap) {
        for (int i=0; i<9; i++) {
            if (i == 6) {
                hashMap.put(i, hashMap.get(i)+1);
            }
            hashMap.put(i, hashMap.get(i)+1);
        }
    }
}
