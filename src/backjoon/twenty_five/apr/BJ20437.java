package backjoon.twenty_five.apr;

import java.io.*;

public class BJ20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++) {
            String str = bf.readLine();
            int K = Integer.parseInt(bf.readLine());

            if(K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for(int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < str.length(); j++) {
                if(alpha[str.charAt(j) - 'a'] < K) continue;

                int count = 1;
                for(int l = j + 1; l < str.length(); l++) {
                    if(str.charAt(j) == str.charAt(l)) count++;
                    if(count == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }
}
