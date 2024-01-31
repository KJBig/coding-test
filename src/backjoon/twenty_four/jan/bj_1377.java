package backjoon.twenty_four.jan;

import java.util.*;
import java.io.*;

public class bj_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N + 1];
        A[0] = new mData(0, 0);
        for (int i = 1; i <=N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        int max = 0;
        for(int i=1; i<=N; i++){
            if(max < A[i].index - i){
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}

