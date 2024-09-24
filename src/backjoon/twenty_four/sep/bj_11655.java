package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj_11655 {
    static char[] alp = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static HashMap<Character, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<alp.length; i++) {
            hashMap.put(alp[i], i);
        }

        for (int i=0; i<split.length; i++) {
            String word = split[i];
            for (int j=0; j<word.length(); j++) {
                char now = word.charAt(j);
                if (Character.isAlphabetic(now)) {
                    char encode = getEncode(now);
                    sb.append(encode);
                } else {
                  sb.append(word.charAt(j));
                }
            }
            sb.append(" ");
        }

        System.out.println(sb);

    }

    private static char getEncode(char now) {
        char encode;
        if (Character.isUpperCase(now)) {
            char lowerNow = Character.toLowerCase(now);
            encode = Character.toUpperCase(alp[(hashMap.get(lowerNow)+13) % alp.length]);
        } else {
            encode = alp[(hashMap.get(now)+13) % alp.length];
        }
        return encode;
    }
}
