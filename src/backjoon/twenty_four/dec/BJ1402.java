package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);


        boolean[] arr = new boolean[M + 1];

        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i * i <= M; i++) {
            if(!arr[i]) {
                for(int j = i * i; j <= M; j += i) {
                    arr[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=N; i<=M; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}
