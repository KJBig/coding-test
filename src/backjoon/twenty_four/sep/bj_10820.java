package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str= br.readLine()) != null) {
            int[] answer = new int[4];
            String[] input = str.split("");
            for (int i = 0; i < input.length; i++) {
                int element = input[i].charAt(0);

                if (element == 32) {
                    answer[3]++;
                } else if (element >= 97) {
                    answer[0]++;
                } else if (element >= 65) {
                    answer[1]++;
                } else {
                    answer[2]++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int N : answer) {
                sb.append(N).append(" ");
            }
            System.out.println(sb);
        }
    }
}
