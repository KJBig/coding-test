package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ2057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println("NO");
            return;
        }

        List<Long> factorials = new ArrayList<>();
        long fact = 1;
        factorials.add(fact);

        for (int i=1; i<=20; i++) {
            fact *= i;
            if (fact > 1000000000000000000L) break;
            factorials.add(fact);
        }

        for (int i=factorials.size()-1; i>=0; i--) {
            if (n >= factorials.get(i)) {
                n -= factorials.get(i);
            }
        }

        if (n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
