package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);
        int X = Integer.parseInt(initInput[2]);

        int[][] allTimes = new int[N][N];


        List<List<Node>> nodes = new ArrayList<>();

        for (int i=0; i<N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            String[] nodeData = br.readLine().split(" ");
            int from = Integer.parseInt(nodeData[0]);
            int to = Integer.parseInt(nodeData[1]);
            int moveTime = Integer.parseInt(nodeData[2]);
            nodes.get(from-1).add(new Node(moveTime, to));
        }

        for (int i=1; i<=N; i++) {
            int[] times = getTimes(N, i, nodes);
            allTimes[i-1] = times;
        }

        int answer = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            int nowMax = allTimes[X-1][i] + allTimes[i][X-1];
            answer = Math.max(answer, nowMax);
        }

        System.out.println(answer);

    }

    private static int[] getTimes(int N, int X, List<List<Node>> nodes) {
        int[] times = new int[N];
        Arrays.fill(times, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.time));
        queue.add(new Node(0, X));
        times[X -1] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> nextNodes = nodes.get(poll.index - 1);
            for (int i=0; i<nextNodes.size(); i++) {
                Node nextNode = nextNodes.get(i);
                int nextTime = poll.time+nextNode.time;
                if (times[nextNode.index-1] > nextTime) {
                    times[nextNode.index-1] = nextTime;
                    queue.add(new Node(nextTime, nextNode.index));
                }
            }

        }
        return times;
    }

    static class Node {
        int time;
        int index;

        public Node(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}
