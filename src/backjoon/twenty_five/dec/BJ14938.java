package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ14938 {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int r = Integer.parseInt(inputs[2]);

        List<Edge>[] graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] item_num = new int[n + 1];
        inputs = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            item_num[i+1] = Integer.parseInt(inputs[i]);
        }

        for (int i=0; i<r; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }

        int result = 0;

        for (int start=1; start<=n; start++) {
            int[] dist = dijkstra(start, n, graph);

            int cnt = 0;
            for (int j=1; j<=n; j++) {
                if (dist[j] <= m) {
                    cnt += item_num[j];
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    public static int[] dijkstra(int start, int n, List<Edge>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(edge -> edge.cost));
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (Edge next : graph[currentNode]) {
                int nextNode = next.node;
                int nextCost = currentCost + next.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    queue.add(new Edge(nextNode, nextCost));
                }
            }
        }

        return dist;
    }

    static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}