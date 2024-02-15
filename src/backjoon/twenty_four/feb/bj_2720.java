package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        for (int i=0; i<N; i++){
            int quarterCount = 0;
            int dimeCount = 0;
            int nickelCount = 0;
            int pennyCount = 0;
            int payment = Integer.parseInt(br.readLine());

            while (payment > 0) {
                if (payment >= quarter) {
                    payment -= quarter;
                    quarterCount++;
                } else if (payment >= dime) {
                    payment -= dime;
                    dimeCount++;
                } else if (payment >= nickel) {
                    payment -= nickel;
                    nickelCount++;
                } else if (payment >= penny) {
                    payment -= penny;
                    pennyCount++;
                }
            }

            System.out.println(quarterCount + " " + dimeCount + " " + nickelCount + " " + pennyCount);

        }
    }
}
