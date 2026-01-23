package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ2668 {

    static int N;
    static int[] NUMBERS;
    static boolean[] VISITED;

    static List<Integer> ANSWER = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        NUMBERS = new int[N+1];
        VISITED = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            int number = Integer.parseInt(br.readLine());
            NUMBERS[i] = number;
        }

        for (int i=1; i<=N; i++) {
            VISITED[i] = true;
            dfs(i, i);
            VISITED[i] = false;
        }

        System.out.println(ANSWER.size());

        ANSWER.sort(Comparator.naturalOrder());
        for (Integer number : ANSWER) {
            System.out.println(number);
        }

    }

    public static void dfs(int start, int target) {
        if(!VISITED[NUMBERS[start]]) {
            VISITED[NUMBERS[start]] = true;
            dfs(NUMBERS[start], target);
            VISITED[NUMBERS[start]] = false;
        }

        if(NUMBERS[start] == target) {
            ANSWER.add(target);
        }
    }

}
