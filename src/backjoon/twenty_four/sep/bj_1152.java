package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String input = br.readLine();
        String[] inputs = input.trim().split(" ");
        answer = inputs.length;
        if (input.equals(" ") || input.equals("")) {
            answer = 0;
        }
        System.out.println(answer);
    }

}
