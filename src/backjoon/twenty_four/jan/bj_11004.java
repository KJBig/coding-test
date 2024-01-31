package backjoon.twenty_four.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_11004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String[] split = br.readLine().split(" ");
        int[] ary = new int[N];

        for(int i=0; i<N; i++){
            ary[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(ary);
        System.out.println(ary[K-1]);
    }
}
