package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ20040 {
    static int[] PARENT;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PARENT = new int[n];
        for(int i=0; i<n; i++) {
            PARENT[i] = i;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(find(x)==find(y)) {
                System.out.println(i+1);
                return;
            }else {
                union(x,y);
            }
        }

        System.out.println(0);
    }

    private static int find(int x) {
        if(x == PARENT[x]) {
            return x;
        }
        return PARENT[x] = find(PARENT[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            PARENT[y] = x;
        }else {
            PARENT[x] = y;
        }
    }

}
