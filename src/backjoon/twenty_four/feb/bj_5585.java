package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int payment = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        while (payment > 0){
            if(payment >= 500){
                payment -= 500;
                count++;
            } else if (payment >= 100) {
                payment -= 100;
                count++;
            } else if (payment >= 50) {
                payment -= 50;
                count++;
            } else if (payment >= 10) {
                payment -= 10;
                count++;
            } else if (payment >= 5) {
                payment -= 5;
                count++;
            } else if (payment >= 1) {
                payment -= 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
