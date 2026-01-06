package backjoon.twenty_six.jan;

import java.io.*;

public class BJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] value = new int[N][2];
        int[] dp = new int[N+1];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            value[i][0] = Integer.parseInt(input[0]);
            value[i][1] = Integer.parseInt(input[1]);
        }

        for(int i=0; i<N; i++) {
            int[] now = value[i];
            if(i+now[0]<=N) {
                dp[i + now[0]] = Math.max(dp[i + now[0]], dp[i] + now[1]);
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]);

        }

        System.out.println(dp[N]);

    }
}


/*
  1   2  3 4 5 6 7
1 10
2 10
3 10
4 10
5 10
6 10
7 10
 */