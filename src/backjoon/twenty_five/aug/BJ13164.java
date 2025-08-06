package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] members = new int[N];
        int[] subs = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            members[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N-1; i++) {
            subs[i] = members[i+1]-members[i];
        }

        Arrays.sort(subs);

        int answer = 0;

        for (int i=0; i<N-K; i++) {
            answer += subs[i];
        }

        System.out.println(answer);

    }
}
