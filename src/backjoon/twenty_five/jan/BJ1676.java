package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger factorialNumber = getFactorialNumber(N);
        String[] numberString = String.valueOf(factorialNumber).split("");
        int answer = 0;
        if (N != 0) {
            for (int i = numberString.length - 1; i >= 0; i--) {
                if (numberString[i].equals("0")) {
                    answer++;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static BigInteger getFactorialNumber(int n) {
        BigInteger bigInteger = new BigInteger(String.valueOf(n));

        for (int i=n-1; i>0; i--) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        return bigInteger;
    }
}
