package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int minA = Integer.parseInt(input[0].replace("6", "5"));
        int minB = Integer.parseInt(input[1].replace("6", "5"));

        int maxA = Integer.parseInt(input[0].replace("5", "6"));
        int maxB = Integer.parseInt(input[1].replace("5", "6"));

        System.out.println((minA+minB) + " " + (maxA+maxB));
    }
}
