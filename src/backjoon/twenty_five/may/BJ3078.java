package backjoon.twenty_five.may;

import java.io.*;
import java.util.*;

public class BJ3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        String[] names = new String[N];

        for (int i=0; i<N; i++) {
            names[i] = br.readLine();
        }

        int start = 0;
        int end = start+K;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=start; i<=end; i++) {
            int nowSize = names[i].length();
            pushHashMap(hashMap, nowSize);
        }

        long answer = 0;
        while (start<end) {
            int nowLength = names[start].length();
            hashMap.put(nowLength, hashMap.get(nowLength)-1);

            if (hashMap.containsKey(nowLength)) {
                answer += hashMap.get(nowLength);
            }

            start++;

            if (end+1 < N) {
                end++;
                pushHashMap(hashMap, names[end].length());
            }

        }

        System.out.println(answer);

    }

    private static void pushHashMap(HashMap<Integer, Integer> hashMap, int nowSize) {
        if (!hashMap.containsKey(nowSize)) {
            hashMap.put(nowSize, 0);
        }
        hashMap.put(nowSize, hashMap.get(nowSize)+1);
    }
}
