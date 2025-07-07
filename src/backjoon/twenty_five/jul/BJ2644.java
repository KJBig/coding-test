package backjoon.twenty_five.jul;

import java.io.*;
import java.util.*;

public class BJ2644 {
    static int N;
    static int[][] GRAPH;
    static boolean[] VISITED;
    static int[] DISTANCE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        GRAPH = new int[N+1][N+1];
        VISITED = new boolean[N+1];
        DISTANCE = new int[N+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            GRAPH[parent][child] =1;
            GRAPH[child][parent] = 1;
        }

        bfs(start);

        if (DISTANCE[end]==0) {
            System.out.println(-1);
        } else {
            System.out.println(DISTANCE[end]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        VISITED[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i=1; i<=N; i++) {
                if (GRAPH[current][i]==1 && !VISITED[i]) {
                    VISITED[i] = true;
                    DISTANCE[i] = DISTANCE[current]+1;
                    queue.offer(i);
                }
            }
        }
    }
}

