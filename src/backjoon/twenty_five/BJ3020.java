package backjoon.twenty_five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] top = new int[N/2];
        int[] bottom = new int[N/2];

        for (int i=1; i<=N; i++) {
            if (i%2 != 0) {
                top[i/2] = Integer.parseInt(br.readLine());
            }
            if (i%2 == 0) {
                bottom[(i/2)-1] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(top);
        Arrays.sort(bottom);

        int min = Integer.MAX_VALUE;
        int num = 0;
        for(int i=1;i<=M;i++){
            int botCount = calc(0, N/2, bottom, i);
            int topCount = calc(0, N/2, top, M-i+1);

            if(min > botCount+topCount){
                min = botCount+topCount;
                num = 1;
            } else if(min == botCount+topCount) {
                num++;
            }
        }

        System.out.println(min+" "+num);
    }

    private static int calc(int left, int right, int[] arr, int height){
        while(left<right){
            int mid = (left+right)/2;

            if(arr[mid] >= height) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return arr.length-right;
    }

}
