package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = word.length();

        List<String> results = new ArrayList<>();

        for (int i=1; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {

                String s1 = word.substring(0, i);
                String s2 = word.substring(i, j);
                String s3 = word.substring(j);

                String reversedWord = reverse(s1) + reverse(s2) + reverse(s3);

                results.add(reversedWord);
            }
        }

        Collections.sort(results);
        System.out.println(results.get(0));
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
