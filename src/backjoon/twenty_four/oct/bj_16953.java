package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_16953 {

    static long MIN_COUNT = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] numbers = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        dfs(numbers[0], numbers[1], 0);

        if (MIN_COUNT == Long.MAX_VALUE) {
            MIN_COUNT = -1;
        }
        System.out.println(MIN_COUNT);
    }

    private static void dfs(long start, long end, int count) {
        if (start == end) {
            MIN_COUNT = Math.min(MIN_COUNT, count+1);
            return;
        }

        if (start > end) {
            return;
        }

        dfs(start*2, end, count+1);
        StringBuilder sb = new StringBuilder();
        String numberString = sb.append(start).append("1").toString();
        dfs(Long.parseLong(numberString), end, count+1);

        return;
    }
}