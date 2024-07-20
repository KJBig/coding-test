package backjoon.twenty_four.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int zeroCount = 0;
        int oneCount = 0;
        int result = 0;
        for (int i=0; i<input.length; i++) {
            if (input[i].equals("0")){
                while (i<input.length-1 && input[i].equals("0")) {
                    i++;
                }
                zeroCount++;
            }
        }

        for (int i=0; i<input.length; i++) {
            if (input[i].equals("1")){
                while (i<input.length-1 && input[i].equals("1")) {
                    i++;
                }
                oneCount++;
            }
        }

        String target = "0";

        if (oneCount < zeroCount) {
            target = "1";
        }

        for (int i=0; i<input.length; i++) {
            if (input[i].equals(target)){
                while (i<input.length-1 && input[i].equals(target)) {
                    i++;
                }
                result++;
            }
        }
        System.out.println(result);
    }
}