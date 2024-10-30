package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_2941 {

    static String[] BOARD = {"dz=", "d-", "c=", "c-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (String target : BOARD) {
            input = input.replace(target, "1");
        }

        System.out.println(input.length());

    }

}