package backjoon.twenty_four.oct;

import java.io.*;
import java.util.Arrays;

public class bj_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dis = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] payment = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long nowPayment = payment[0];
        long totalPayment = payment[0] * dis[0];

        for (int i = 1; i < N - 1; i++) {
            if (nowPayment > payment[i]) {
                nowPayment = payment[i];
            }
            totalPayment += nowPayment * dis[i];
        }
        System.out.println(totalPayment);
    }
}