package backjoon;

import java.util.*;
import java.io.*;

public class bj_1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int[] ary = new int[split.length];

        for(int i=0; i<split.length; i++){
            ary[i] = Integer.parseInt(split[i]);
        }

        for(int i=0; i<ary.length; i++){
            int maxNum = -1;
            int maxIndex = -1;
            for(int j=i; j<ary.length; j++){
                if(maxNum < ary[j]){
                    maxNum = ary[j];
                    maxIndex = j;
                }
            }
            swap(ary, i, maxIndex);
        }

        for (int i : ary) {
            System.out.print(i);
        }
    }

    public static void swap(int[] ary, int i, int maxIndex){
        int temp = ary[i];
        ary[i] = ary[maxIndex];
        ary[maxIndex] = temp;
    }
}
