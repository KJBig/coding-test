package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];

        int bSize = b.length();
        int start = 0;
        int end = a.length();
        int maxNum = 0;

        while (end <= bSize) {
            int matchCount = getMatchCount(a, b.substring(start, end));
            maxNum = Math.max(maxNum, matchCount);
            start++;
            end++;
        }

        int totalMatchNum = maxNum + b.length()-a.length();

        System.out.println(bSize - totalMatchNum);

    }

    private static int getMatchCount(String a, String substring) {
        int size = a.length();
        int matchCount = 0;
        for (int i=0; i<size; i++) {
            if (a.charAt(i) == substring.charAt(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
