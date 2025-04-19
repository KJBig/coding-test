package backjoon.twenty_five.apr;

import java.io.*;

public class BJ1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int action = Integer.parseInt(split[0]);

        long[] factorial = new long[21];
        factorial[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        if (action == 1) {
            long k = Long.parseLong(split[1]);
            boolean[] visited = new boolean[N + 1];
            int[] result = new int[N];

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;

                    if (factorial[N - i - 1] < k) {
                        k -= factorial[N - i - 1];
                    } else {
                        result[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            int[] perm = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                perm[i] = Integer.parseInt(split[i]);
            }

            long rank = 1;
            boolean[] visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                int current = perm[i];
                visited[current] = true;

                for (int j = 1; j < current; j++) {
                    if (!visited[j]) {
                        rank += factorial[N - i];
                    }
                }
            }

            System.out.println(rank);
        }
    }
}