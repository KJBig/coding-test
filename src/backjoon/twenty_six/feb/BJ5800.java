package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=K; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int[] scores = new int[N];
            for (int j=0; j<N; j++) {
                scores[j] = Integer.parseInt(input[j+1]);
            }
            Arrays.sort(scores);

            int minScore = scores[0];
            int maxScore = scores[N-1];
            int largestGap = 0;

            for (int l=0; l<N-1; l++) {
                largestGap = Math.max(largestGap, scores[l+1]-scores[l]);
            }

            sb.append("Class ").append(i).append("\n");
            sb.append("Max ").append(maxScore)
                    .append(", Min ").append(minScore)
                    .append(", Largest gap ").append(largestGap)
                    .append("\n");
        }

        System.out.println(sb);
    }

}
