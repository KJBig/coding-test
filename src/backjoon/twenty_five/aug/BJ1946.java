package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int caseIndex = 0; caseIndex < T; caseIndex++) {
            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[N][2];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                scores[i][0] = Integer.parseInt(input[0]);
                scores[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(scores, Comparator.comparing(a -> a[0]));

            int answer = 1;
            int bestInterviewRank = scores[0][1];

            for (int i = 1; i < N; i++) {
                if (scores[i][1] <= bestInterviewRank) {
                    answer++;
                    bestInterviewRank = scores[i][1];
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}