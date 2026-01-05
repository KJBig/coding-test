package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ10819 {

    static int[] NUMBERS;
    static boolean[] VISITED;
    static int ANSWER = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        NUMBERS = new int[N];
        VISITED = new boolean[N];

        String[] input = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            NUMBERS[i] = Integer.parseInt(input[i]);
        }

        dfs(N, new ArrayList<>());

        System.out.println(ANSWER);

    }

    private static void dfs(int n, List<Integer> nowNumbers) {
        if (nowNumbers.size() == n) {
            int value = calNumber(nowNumbers, n);
            ANSWER = Math.max(ANSWER, value);
        }

        for (int i=0; i<n; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                nowNumbers.add(NUMBERS[i]);
                dfs(n, nowNumbers);
                nowNumbers.remove(nowNumbers.size()-1);
                VISITED[i] = false;
            }
        }
    }

    private static int calNumber(List<Integer> nowNumbers, int n) {
        int result = 0;

        for (int i=1; i<n; i++) {
            result += Math.abs(nowNumbers.get(i-1) - nowNumbers.get(i));
        }

        return result;
    }
}
