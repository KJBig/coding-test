package backjoon;

import java.io.*;

public class bj_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for(int i=0; i<N; i++){
             list[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N-i-1; j++){
                if(list[j] > list[j+1]){
                    int temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                }
            }
        }

        for (int i : list) {
            System.out.println(i);
        }

    }
}
