package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int five = 0;
        int two = 0;
        int result = 0;

        while (N > 0) {
            if (N >= 5) {
                N -= 5;
                five++;
            } else if (N >= 2) {
                N -= 2;
                two++;
            } else if (N > 0 && N < 2) {
                N += 5;
                N -= 2;
                five--;
                two++;
            }

            if (five < 0) {
                result = -1;
                break;
            }
        }

        if (result != -1) {
            result = five + two;
        }
        System.out.println(result);
    }
}
