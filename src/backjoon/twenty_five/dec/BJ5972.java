package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        HashMap<Integer, List<Edge>> edges = new HashMap<>();
        int[] nodeCowCount = new int[N+1];
        for (int i=0; i<N; i++) {
            nodeCowCount[i+1] = -1;
        }

        for (int i=0; i<M; i++) {
            String[] nodeData = br.readLine().split(" ");
            int start = Integer.parseInt(nodeData[0]);
            int end = Integer.parseInt(nodeData[1]);
            int cowCount = Integer.parseInt(nodeData[2]);

            if (!edges.containsKey(start)) {
                edges.put(start, new ArrayList<>());
            }
            edges.get(start).add(new Edge(end, cowCount));

            if (!edges.containsKey(end)) {
                edges.put(end, new ArrayList<>());
            }
            edges.get(end).add(new Edge(start, cowCount));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(edge -> edge.cowCount));
        nodeCowCount[1] = 0;
        queue.add(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();

            for (Edge edge : edges.get(poll.index)) {
                if (nodeCowCount[edge.index] == -1 || nodeCowCount[edge.index] > nodeCowCount[poll.index]+edge.cowCount) {
                    nodeCowCount[edge.index] = nodeCowCount[poll.index]+edge.cowCount;
                    queue.add(edge);
                }
            }

        }

        System.out.println(nodeCowCount[N]);

    }

    static class Edge {
        int index;
        int cowCount;

        public Edge(int index, int cowCount) {
            this.index = index;
            this.cowCount = cowCount;
        }
    }
}
