package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15666 {
    static int N, M;
    static int[] arr, printArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        printArr = new int[M];
        String[] number = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(number[i]);
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(printArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i=start; i<N; i++) {
            int now = arr[i];
            if(before != now) {
                before = now;
                printArr[depth] = arr[i];
                dfs(i, depth + 1);
            }

        }
    }
}
