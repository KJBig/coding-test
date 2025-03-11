package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BJ1922 {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        int M = Integer.parseInt(br.readLine()); // 연결 가능한 간선 개수

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            edges.add(new int[]{cost, a, b});
        }

        edges.sort(Comparator.comparingInt(o -> o[0]));

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int totalCost = 0; // 최소 비용 합
        int edgeCount = 0; // 현재 선택된 간선 개수

        for (int[] edge : edges) {
            int cost = edge[0];
            int a = edge[1];
            int b = edge[2];

            // 사이클이 발생하지 않으면 선택
            if (find(a) != find(b)) {
                union(a, b);
                totalCost += cost;
                edgeCount++;

                // 모든 정점을 연결하는 최소 간선을 선택하면 종료
                if (edgeCount == N - 1) break;
            }
        }

        // 출력: 최소 비용
        System.out.println(totalCost);
    }
}
