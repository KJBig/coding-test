package backjoon.twenty_five.mar;

import java.io.*;

public class BJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = N/3;
        N = N%3;

        if ((N+count)%2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
