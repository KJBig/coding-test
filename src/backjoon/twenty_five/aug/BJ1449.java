package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine() );
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] p = new int[N];
        st = new StringTokenizer( br.readLine() );
        for(int i=0;i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);

        int t_count = 1;
        double tape = (p[0] - 0.5) + L;
        for( int i =1; i < N; i++) {
            if( tape < p[i]+0.5 ) {
                t_count++;
                tape = (p[i] - 0.5) + L;
            }
        }

        System.out.println(t_count);

    }
}
