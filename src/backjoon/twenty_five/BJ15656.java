package backjoon.twenty_five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15656 {

    static int N;
    static int M;
    static int[] ARR, PRINT_ARR;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        String[] numbers = br.readLine().split(" ");
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        ARR = new int[N];
        PRINT_ARR = new int[M];

        for (int i=0; i<N; i++) {
            ARR[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(ARR);

        dfs(0);

        System.out.print(SB);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                SB.append(PRINT_ARR[i] + " ");
            }
            SB.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            PRINT_ARR[depth] = ARR[i];
            dfs( depth + 1);
        }
    }
}
