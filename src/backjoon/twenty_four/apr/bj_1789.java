package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1789 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int i = 1;
        while (true) {
            if (S>=i) {
                S -= i;
            } else {
                break;
            }
            i++;
        }

        System.out.println(i-1);

    }
}