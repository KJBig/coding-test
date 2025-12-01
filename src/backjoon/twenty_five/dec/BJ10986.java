package backjoon.twenty_five.dec;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long answer = 0;
        long[] sums = new long[N+1];
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i <N+1; i++) {
            sums[i] = (sums[i-1] + Integer.parseInt(st.nextToken())) % M;
            if(sums[i] == 0) {
                answer++;
            }
            count[(int) sums[i]]++;
        }

        // (sums[i] - sums[i-1])%M == iC2 + i-1C2 == (count[i]*count[i-1])/2
        for(int i=0; i<M; i++) {
            if(count[i]>1) {
                answer += (count[i] * (count[i]-1) / 2);
            }
        }

        System.out.println(answer);
    }
}
