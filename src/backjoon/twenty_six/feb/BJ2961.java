package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ2961 {

    static int N;
    static int[] SOUR;
    static int[] BITTER;
    static long MIN_DIF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        SOUR = new int[N];
        BITTER = new int[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            SOUR[i] = Integer.parseInt(st.nextToken());
            BITTER[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0, 1, 0);

        System.out.println(MIN_DIF);
    }

    static void bfs(int cnt, int used, long sSum, long bSum) {
        if (cnt == N) {
            if (used > 0) {
                long diff = Math.abs(sSum - bSum);
                MIN_DIF = Math.min(MIN_DIF, diff);
            }
            return;
        }

        bfs(cnt + 1, used + 1, sSum * SOUR[cnt], bSum + BITTER[cnt]);
        bfs(cnt + 1, used, sSum, bSum);
    }
}
