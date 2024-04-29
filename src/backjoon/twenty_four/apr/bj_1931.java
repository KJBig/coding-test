package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int pre = 0;
        int[][] ary = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            ary[i][0] = Integer.parseInt(split[0]);
            ary[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(ary, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int i = 0; i < N; i++) {
            if(pre <= ary[i][0]) {
                pre = ary[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}
