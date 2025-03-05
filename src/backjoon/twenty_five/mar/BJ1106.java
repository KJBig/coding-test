package backjoon.twenty_five.mar;

import java.io.*;
import java.util.Arrays;

public class BJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int cityNum = Integer.parseInt(input[1]);
        int[][] dp = new int[C+1][cityNum+1];
        String[] firstCityData = br.readLine().split(" ");
        int firstCost = Integer.parseInt(firstCityData[0]);
        int firstValue = Integer.parseInt(firstCityData[1]);

        for (int i=1; i<=C; i++) {
            dp[i][1] = getRequiredCost(firstCost, firstValue, i);
        }

        for (int i=2; i<=cityNum; i++) {
            String[] cityData = br.readLine().split(" ");
            int cost = Integer.parseInt(cityData[0]);
            int value = Integer.parseInt(cityData[1]);

            for (int j=1; j<=C; j++) {
                int requiredCost = getRequiredCost(cost, value, j);

                // 기대 인원보다 많은 인원을 유치시킬 수 있을 때
                if (j < value) {
                    // 현재 도시의 최소비용 VS 이전 도시만 방문했을 때의 최솟값
                    dp[j][i] = Math.min(dp[j][i-1], requiredCost);
                    continue;
                }

                // 기대 인원보다 적은 인원을 유치시킬 수 있을 때
                int subValue = j - value;
                if (subValue > 0) {
                    requiredCost = cost;
                }
                // 이전의 최솟값 VS 현재도시 비용 + (기대인원 - 유치인원)인 인원의 최솟값
                dp[j][i] = Math.min(dp[j][i-1], requiredCost + dp[subValue][i]);
            }

        }

        System.out.print(dp[C][cityNum]);
    }

    private static int getRequiredCost(int cost, int value, int j) {
        int requiredCost;
        if (j <= value) {
            requiredCost = cost;
        } else {
            requiredCost = (j / value)* cost;
            if (j % value != 0) {
                requiredCost+= cost;
            }
        }
        return requiredCost;
    }
}
