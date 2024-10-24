package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_12847 {
    public static void main(String[] args) throws IOException {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        String[] payments = br.readLine().split(" ");
        long nowPayment = 0;
        int start = 0;
        int end = M-1;

        for (int i=start; i<=end; i++) {
            nowPayment += Integer.parseInt(payments[i]);
        }

        answer = nowPayment;

        while (end < N-1) {
            nowPayment -= Integer.parseInt(payments[start]);
            start++;
            end++;
            nowPayment += Integer.parseInt(payments[end]);
            answer = Math.max(answer, nowPayment);
        }

        System.out.println(answer);

    }

}
