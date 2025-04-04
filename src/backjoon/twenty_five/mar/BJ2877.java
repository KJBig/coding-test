package backjoon.twenty_five.mar;

import java.io.*;
import java.util.*;

public class BJ2877 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 1;

        StringBuilder sb = new StringBuilder();

        while (N >= 2) {
            sb.append(N % 2);
            N = N / 2;
        }

        sb.delete(sb.length(), sb.length());
        String convertNum = sb.reverse().toString();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < convertNum.length(); i++) {
            if (convertNum.charAt(i) == '0') {
                answer.append("4");
            } else {
                answer.append("7");

            }

            System.out.println(answer);


        }
    }
}
