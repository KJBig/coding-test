package backjoon.twenty_six.feb;

import java.io.*;

public class BJ1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        String[] dna = new String[n];
        for (int i=0; i<n; i++) {
            dna[i] = br.readLine().trim();
        }

        char[] order = {'A', 'C', 'G', 'T'};
        StringBuilder ans = new StringBuilder();
        int totalDist = 0;

        for (int col=0; col<m; col++) {
            int[] cnt = new int[4];

            for (int row=0; row<n; row++) {
                cnt[getIndex(dna[row].charAt(col))]++;
            }

            int bestIdx = 0;
            for (int i=1; i<4; i++) {
                if (cnt[i] > cnt[bestIdx]) {
                    bestIdx = i;
                }
            }

            ans.append(order[bestIdx]);
            totalDist += (n-cnt[bestIdx]);
        }

        System.out.println(ans);
        System.out.println(totalDist);
    }

    private static int getIndex(char c) {
        if (c == 'A') {
            return 0;
        }
        if (c == 'C') {
            return 1;
        }
        if (c == 'G') {
            return 2;
        }
        return 3;
    }

}
