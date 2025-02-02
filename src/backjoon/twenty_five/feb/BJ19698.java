package backjoon.twenty_five.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int W = Integer.parseInt(inputs[1]);
        int H = Integer.parseInt(inputs[2]);
        int L = Integer.parseInt(inputs[3]);

        int wSize = W/L;
        int hSize = H/L;

        if (wSize*hSize > N) {
            System.out.println(N);
        } else {
            System.out.println(wSize*hSize);
        }

    }
}
