package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Node[] times = new Node[N];
        List<List<Node>> nodes = new ArrayList<>();

        for (int i=0; i<N; i++) {
            times[i] = new Node(Integer.MAX_VALUE, i+1);
            nodes.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);

            Node node = new Node(time, to);
            nodes.get(from-1).add(node);
        }

        String[] answerInput = br.readLine().split(" ");
        int start = Integer.parseInt(answerInput[0]);
        int end = Integer.parseInt(answerInput[1]);

        int[] parent = new int[N];
        Arrays.fill(parent, 0);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.time));
        Node nowNode = new Node(0, start);
        queue.add(nowNode);
        times[start-1].time = 0;
        parent[start-1] = -1;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.time > times[poll.index-1].time) {
                continue;
            }

            List<Node> adjNodes = nodes.get(poll.index - 1);

            for (int i=0; i< adjNodes.size(); i++) {
                Node nextNode = adjNodes.get(i);
                int nextTime = poll.time+nextNode.time;

                if (times[nextNode.index-1].time > nextTime) {
                    times[nextNode.index-1].time = nextTime;
                    parent[nextNode.index-1] = poll.index;

                    Node newNode = new Node(nextTime, nextNode.index);
                    queue.add(newNode);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int nowIndex = end;
        while (nowIndex != start) {
            path.add(nowIndex);
            nowIndex = parent[nowIndex-1];
        }
        path.add(nowIndex);
        Collections.reverse(path);

        System.out.println(times[end-1].time);
        System.out.println(path.size());
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i + 1 < path.size()) System.out.print(" ");
        }
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


