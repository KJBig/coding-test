package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sequence = 1;
        while (true) {
            String[] split = br.readLine().split(" ");
            int L = Integer.parseInt(split[0]);
            int P = Integer.parseInt(split[1]);
            int V = Integer.parseInt(split[2]);

            if (L==0 && P==0 && V==0) {
                break;
            }

            int div = V/P;
            int answer = (div*L);
            int rest = V%P;
            if (rest > L) {
                rest = L;
            }
            answer += rest;

            System.out.println("Case " + sequence + ": " + answer);
            sequence++;

        }
    }
}
