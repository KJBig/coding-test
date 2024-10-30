package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj_25206 {

    static String[] BOARD = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double totalSum = 0;
        HashMap<String, Double> hashMap = new HashMap<>();

        double startScore = 4.5;
        for (int i=0; i<BOARD.length-1; i++) {
            hashMap.put(BOARD[i], startScore);
            startScore -= 0.5;
        }
        hashMap.put(BOARD[BOARD.length-1], 0.0);


        for (int i=0; i<20; i++) {
            String[] input = br.readLine().split(" ");
            if (input[2].equals("P")) {
                continue;
            }
            double grade = Double.parseDouble(input[1]);
            Double score = hashMap.get(input[2]);
            sum += (grade*score);
            totalSum += grade;
        }

        System.out.println(String.format("%.6f", Math.round((sum / totalSum) * 1000000) / 1000000.0));

    }

}