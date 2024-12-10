package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");
        String[] M = br.readLine().split("");

        int[][] dp = new int[N.length+1][M.length+1];

        for (int i=1; i<=N.length; i++) {
            for (int j=1; j<=M.length; j++) {
                if (N[i-1].equals(M[j-1])) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[N.length][M.length]);

        Stack<String> stack = new Stack<>();
        int i=N.length;
        int j=M.length;
        while(i>0 && j>0) {
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else {
                stack.push(N[i-1]);
                i--;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k=0; k<dp[N.length][M.length]; k++) {
            sb.append(stack.pop());
        }

        System.out.println(sb);



    }
}