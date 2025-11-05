package backjoon.twenty_five.nov;

import java.util.*;


public class PG42898 {
    class Solution {
        static int MOD = 1000000007;
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[] DY = {-1, 0};
            int[] DX = {0, -1};
            int[][] dp = new int[n][m];
            boolean[][] water = new boolean[n][m];
            
            for (int i=0; i<puddles.length; i++) {
                int[] puddle = puddles[i];
                water[puddle[1]-1][puddle[0]-1] = true;
            }
            dp[0][0] = 1;
            
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (water[i][j]) {
                        continue;
                    }
                    if (i == 0 && j == 0) { 
                        continue;
                    }
                    
                    long up = (i > 0) ? dp[i-1][j] : 0;
                    long left = (j > 0) ? dp[i][j-1] : 0;
                    dp[i][j] += (int)(up+left)%MOD;   
                }   
            }
            
            answer = dp[n-1][m-1];
            return answer;
        }
        
    }
}
