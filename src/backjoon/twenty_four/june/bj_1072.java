package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        long initRate = y*100/x;

        if(initRate ==100 || initRate ==99) {
            System.out.println(-1);
            return ;
        }
        long start = 1;
        long end = (int)x;

        while(start<end) {
            long mid = (start+end)/2;

            long nowX = x+mid;
            long nowY = y+mid;

            long rate = nowY*100 /nowX;
            if(rate > initRate) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        System.out.println(end);

    }
}
