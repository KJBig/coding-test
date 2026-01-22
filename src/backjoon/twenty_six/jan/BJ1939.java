package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ1939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);

        List<List<NodeData>> nodeDatas = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            nodeDatas.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            String[] nodeInput = br.readLine().split(" ");
            int a = Integer.parseInt(nodeInput[0]);
            int b = Integer.parseInt(nodeInput[1]);
            int c = Integer.parseInt(nodeInput[2]);

            nodeDatas.get(a).add(new NodeData(b, c));
            nodeDatas.get(b).add(new NodeData(a, c));
        }

        String[] pointInput = br.readLine().split(" ");
        int start = Integer.parseInt(pointInput[0]);
        int end = Integer.parseInt(pointInput[1]);

        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        dist[start] = Integer.MAX_VALUE;

        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparing(state -> state.cap, Comparator.reverseOrder()));
        queue.add(new State(start, dist[start]));

        while (!queue.isEmpty()) {
            State poll = queue.poll();

            if (poll.cap < dist[poll.index]) {
                continue;
            }

            if (poll.index == end) {
                System.out.println(poll.cap);
                return;
            }

            for (NodeData next : nodeDatas.get(poll.index)) {
                int nextCap = Math.min(poll.cap, next.weight);
                if (nextCap > dist[next.index]) {
                    dist[next.index] = nextCap;
                    queue.add(new State(next.index, nextCap));
                }
            }
        }

        System.out.println(dist[end]);
    }

    static class NodeData {
        int index;
        int weight;

        public NodeData(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    static class State {
        int index;
        int cap;

        public State(int index, int cap) {
            this.index = index;
            this.cap = cap;
        }
    }
}
