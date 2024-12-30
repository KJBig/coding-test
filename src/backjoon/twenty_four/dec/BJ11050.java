package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int factorialNumber1 = getFactorial(N);
        int factorialNumber2 = getFactorial(M);
        int factorialNumber3 = getFactorial(N-M);

        System.out.println(factorialNumber1 + ", " + factorialNumber2 + ", " + factorialNumber3 + ", " + (factorialNumber2*factorialNumber3));

        int answer = 0;
        if (factorialNumber1 != 0 && factorialNumber2 != 0 && factorialNumber3 != 0) {
            answer = factorialNumber1 / (factorialNumber2*factorialNumber3);
        }

        System.out.println(answer);
    }

    private static int getFactorial(int number) {
        int result = 1;

        for (int i=1; i<=number; i++) {
            result *= i;
        }
        return result;
    }
}
