package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        BigInteger resultAdd = a.add(b);
        BigInteger resultSub = a.subtract(b);
        BigInteger resultMul = a.multiply(b);
        System.out.println(resultAdd);
        System.out.println(resultSub);
        System.out.println(resultMul);
    }
}
