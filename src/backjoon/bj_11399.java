package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] ary = new int[N];

        for(int i=0; i<N; i++){
            ary[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(ary);
        int result = 0;
        for (int i=1; i<N; i++) {
            ary[i] = ary[i-1] + ary[i];
        }

        for (int i : ary) {
            result+=i;
        }
        System.out.println(result);
    }
}
