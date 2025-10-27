package backjoon.twenty_five.oct;

import java.io.*;
import java.util.*;

public class BJ1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int v=1; v<=N; v++) {
            if (inDegree[v] == 0) {
                queue.add(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int nxt : adj.get(cur)) {
                if (--inDegree[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}

