package backjoon.twenty_five.oct;

import java.io.*;

public class BJ1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];
        int len = 0;

        for (int i=0; i<N; i++) {
            int x = numbers[i];
            int pos = searchMinIndex(dp, len, x);
            dp[pos] = x;
            if (pos == len) {
                len++;
            }
        }

        System.out.println(N - len);
    }

    private static int searchMinIndex(int[] dp, int len, int number) {
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right+left) / 2;
            if (dp[mid] >= number) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}

/*

8
1 2 3 4 1 2 3 4
 */