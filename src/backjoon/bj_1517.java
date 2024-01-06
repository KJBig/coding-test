package backjoon;

import java.io.*;
import java.util.*;

public class bj_1517 {
    public static int[] A, temp;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        temp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
//        String[] split = br.readLine().split(" ");

        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        merget_sort(1, N);
        System.out.println(result);
    }

    private static void merget_sort(int s, int e) {
        if(e-s < 1) return;
        int m = s + (e-s) / 2;

        merget_sort(s, m);
        merget_sort(m+1, e);

        for(int i=s; i<=e; i++){
            temp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1 <= m && index2 <= e){
            if(temp[index1] > temp[index2]){
                A[k] = temp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            }else{
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m){
            A[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
