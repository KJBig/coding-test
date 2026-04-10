package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ1944 {

    static int N, M;
    static char[][] MAP;
    static List<Point> POINTS = new ArrayList<>();
    static List<Edge> EDGES = new ArrayList<>();
    static int[] PARENT;

    static int[] DY = {-1, 1, 0, 0};
    static int[] DX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);

        MAP = new char[N][N];
        int idCount = 0;
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                MAP[i][j] = line.charAt(j);
                if (MAP[i][j] == 'S' || MAP[i][j] == 'K') {
                    POINTS.add(new Point(i, j, idCount++));
                }
            }
        }

        for (Point p : POINTS) {
            bfs(p);
        }

        EDGES.sort(Comparator.comparingInt(e -> e.weight));

        PARENT = new int[POINTS.size()];
        for (int i=0; i<PARENT.length; i++) {
            PARENT[i] = i;
        }

        int totalWeight = 0;
        int edgeCount = 0;

        for (Edge edge : EDGES) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalWeight += edge.weight;
                edgeCount++;
            }
        }

        if (edgeCount == M) {
            System.out.println(totalWeight);
        } else {
            System.out.println("-1");
        }
    }

    private static void bfs(Point start) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N][N];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        queue.add(new int[]{start.y, start.x});
        dist[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            if (MAP[y][x] == 'S' || MAP[y][x] == 'K') {
                if (dist[y][x] > 0) {
                    int targetId = -1;
                    for (Point p : POINTS) {
                        if (p.y == y && p.x == x) {
                            targetId = p.id;
                            break;
                        }
                    }
                    EDGES.add(new Edge(start.id, targetId, dist[y][x]));
                }
            }

            for (int i=0; i<4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny<0 || N<=ny || nx<0 || N<=nx) {
                    continue;
                }

                if (MAP[ny][nx] != '1' && dist[ny][nx] == -1) {
                    dist[ny][nx] = dist[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static int find(int x) {
        if (PARENT[x] == x) return x;
        return PARENT[x] = find(PARENT[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            PARENT[y] = x;
        }
    }

    static class Point {
        int y;
        int x;
        int id;

        public Point(int y, int x, int id) {
            this.y = y;
            this.x = x;
            this.id = id;
        }
    }

    static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}