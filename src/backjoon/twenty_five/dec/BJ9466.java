package backjoon.twenty_five.dec;

import java.util.*;
import java.io.*;

public class BJ9466 {
    static int[] NUMBERS;
    static boolean[] VISITED, DONE;
    static int COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int p=0; p<T; p++){
            int n = Integer.parseInt(br.readLine());
            NUMBERS = new int[n+1];
            VISITED = new boolean[n+1];
            DONE = new boolean[n+1];
            COUNT = 0;

            st = new StringTokenizer(br.readLine());

            for(int i=1; i<= n; i++){
                NUMBERS[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                if(!DONE[i]){
                    dfs(i);
                }
            }
            System.out.println((n-COUNT));
        }

    }

    public static void dfs(int n){
        if(VISITED[n]){
            DONE[n] = true;
            COUNT++;
        }else{
            VISITED[n] = true;
        }

        if(!DONE[NUMBERS[n]]){
            dfs(NUMBERS[n]);
        }

        VISITED[n] = false;
        DONE[n] = true;
    }
}
