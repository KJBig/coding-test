package backjoon.twenty_five.apr;

import java.io.*;
import java.util.*;

public class BJ1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                String[] edge = br.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int[] colors = new int[V + 1];
            boolean isBipartite = true;

            for (int start = 1; start <= V; start++) {
                if (colors[start] == 0) {
                    if (!bfs(graph, colors, start)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    private static boolean bfs(List<List<Integer>> graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (colors[next] == 0) {
                    colors[next] = 3 - colors[node];
                    queue.add(next);
                } else if (colors[next] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
