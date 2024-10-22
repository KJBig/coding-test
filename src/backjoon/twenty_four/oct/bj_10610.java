package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        List<String> numbers = new ArrayList<>();
        boolean flag = false;

        for (String s : split) {
            numbers.add(s);
            if (s.equals("0")) {
                flag = true;
            }
        }

        if (flag && isOK(numbers)) {
            flag = true;
        } else {
            flag = false;
        }

        if (!flag) {
            System.out.println("-1");
        } else {

            numbers.sort(Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (String number : numbers) {
                sb.append(number);
            }
            System.out.println(sb);
        }

    }

    private static boolean isOK(List<String> numbers) {
        long sum = 0;
        for (int i=0; i<numbers.size(); i++) {
            sum += Long.parseLong(numbers.get(i));
        }
        if (sum % 3 == 0) {
            return true;
        }
        return false;
    }
}
