package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ13023 {
    static List<List<Integer>> F = new ArrayList<>();
    static boolean[] VISITED;
    static boolean ANSWER = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            F.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            F.get(start).add(end);
            F.get(end).add(start);
        }

        for (int i=0; i<N; i++) {
            VISITED = new boolean[N];
            dfs(i, 0);
        }


        if (ANSWER) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int now, int depth) {
        if (depth == 4) {
            ANSWER = true;
            return;
        }

        VISITED[now] = true;

        List<Integer> fs = F.get(now);
        for (Integer f : fs) {
            if (ANSWER) {
                return;
            }
            if (!VISITED[f]) {
                dfs(f, depth+1);
            }
        }

        VISITED[now] = false;

    }
}