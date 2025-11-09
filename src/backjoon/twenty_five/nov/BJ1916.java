package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] costs = new int[N];
        List<List<Node>> nodes = new ArrayList<>();

        for (int i=0; i<N; i++) {
            nodes.add(new ArrayList<>());
            costs[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            nodes.get(from-1).add(new Node(cost, to));
        }

        String[] resultInput = br.readLine().split(" ");

        int start = Integer.parseInt(resultInput[0]);
        int end = Integer.parseInt(resultInput[1]);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        queue.add(new Node(0, start));
        costs[start-1] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> adjNodes = nodes.get(poll.index-1);

            if (poll.cost > costs[poll.index - 1]) {
                continue;
            }

            for (int i=0; i<adjNodes.size(); i++) {
                Node node = adjNodes.get(i);
                int nextCost = costs[poll.index - 1] + node.cost;
                if (costs[node.index-1] > nextCost) {
                    costs[node.index-1] = nextCost;
                    queue.add(node);
                }
            }
        }

        System.out.println(costs[end-1]);

    }

    static class Node {
        int cost;
        int index;

        public Node(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
}
