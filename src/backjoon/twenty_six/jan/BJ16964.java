package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16964 {

    static List<List<Integer>> GRAPH = new ArrayList<>();
    static List<Integer> ANSWER = new ArrayList<>();
    static boolean[] VISITED;
    static int[] POS;
    static int[] ORDER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<=N; i++) {
            GRAPH.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            GRAPH.get(start).add(end);
            GRAPH.get(end).add(start);
        }

        POS = new int[N+1];
        ORDER = new int[N+1];

        String[] orderInput = br.readLine().split(" ");

        for (int i=1; i<=N; i++) {
            ORDER[i] = Integer.parseInt(orderInput[i-1]);
            POS[ORDER[i]] = i;
        }

        for (int i=1; i<=N; i++) {
            GRAPH.get(i).sort(Comparator.comparingInt(number -> POS[number]));
        }

        VISITED = new boolean[N+1];

        dfs(1);

        for(int i=0; i<N; i++) {
            if(ANSWER.get(i) != ORDER[i+1]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    private static void dfs(int start) {
        if (VISITED[start]) {
            return;
        }

        System.out.println("start: " + start);
        VISITED[start] = true;
        ANSWER.add(start);

        for (int i : GRAPH.get(start)) {
            if (!VISITED[i]) {
                dfs(i);
            }
        }
    }

}
