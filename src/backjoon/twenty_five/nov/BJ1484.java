package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int now=1; now<=G; now++) {
            if (canNow(now, G)) {
                numbers.add(now);
            }
        }

        if (numbers.isEmpty()) {
            numbers.add(-1);
        }

        for (Integer number : numbers) {
            System.out.println(number);
        }

    }

    private static boolean canNow(int now, int g) {
        if (g-now <= 0) {
            return false;
        }

        int start = 1;
        int end = now;
        int mid;

        while (start <= end) {
            mid = (start+end)/2;
            if (mid > now) {
                end = mid-1;
                continue;
            }

            long target = (long)now*now - (long)mid*mid;
            if (target == g) {
                return true;
            } else if (target < g) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return false;
    }
}