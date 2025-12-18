package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primes = findPrimes(4_000_000);
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 1;
        int sum = primes.get(start) + primes.get(end);
        int count = 0;
        if (N == 1) {
            System.out.println(0);
            return;
        }

        if (N == 2) {
            System.out.println(1);
            return;
        }

        if (N == 3) {
            System.out.println(1);
            return;
        }

        while (start <= end) {
            if (sum == N) {
                count++;
                sum -= primes.get(start);
                start++;
            } else if (sum < N) {
                if (end+1 >= primes.size()) {
                    break;
                }
                end++;
                sum += primes.get(end);
            } else {
                sum -= primes.get(start);
                start++;
            }
        }

        System.out.println(count);

    }

    public static List<Integer> findPrimes(int limit) {
        boolean[] isPrime = new boolean[limit+1];

        for (int i=2; i<=limit; i++) {
            isPrime[i] = true;
        }

        for (int i=2; i*i<=limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
