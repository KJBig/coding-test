package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int total = Integer.parseInt(input[0]);
        int kim = Integer.parseInt(input[1]);
        int lim = Integer.parseInt(input[2]);

        int round = 0;

        while (kim != lim) {
            kim -= kim/2;
            lim -= lim/2;
            round++;
        }

        System.out.println(round);

    }
}
