package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N>0){
            if (N >= 5 && N%5 == 0){
                N -= 5;
                count++;
                continue;
            }

            if (N >= 3){
                N -= 3;
                count++;
                continue;
            }
            N = -1;
            count = -1;
        }

        System.out.println(count);

    }
}
