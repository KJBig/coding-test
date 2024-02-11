package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int result = 0;
            int count = 0;
            String[] split = br.readLine().split("");
            for (String s : split) {
                if(!s.equals("O")){
                    count = 0;
                    continue;
                }
                count++;
                result += count;
            }
            System.out.println(result);
        }
    }
}
