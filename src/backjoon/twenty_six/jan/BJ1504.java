package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ1504 {

    static List<List<Node>> EDGES;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int n = Integer.parseInt(initInput[0]);
        int e = Integer.parseInt(initInput[1]);

        EDGES = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            EDGES.add(new ArrayList<>());
        }

        for (int i=0; i<e; i++) {
            String[] edgeInput = br.readLine().split(" ");
            int start = Integer.parseInt(edgeInput[0]);
            int end = Integer.parseInt(edgeInput[1]);
            int time = Integer.parseInt(edgeInput[2]);

            EDGES.get(start).add(new Node(end, time));
            EDGES.get(end).add(new Node(start, time));
        }

        String[] wayInput = br.readLine().split(" ");
        int pointOne = Integer.parseInt(wayInput[0]);
        int pointTwo = Integer.parseInt(wayInput[1]);

        // 거리 계산
        int eachPoint = getTiniestTime(pointOne,  pointTwo, n);
        int startToOne = getTiniestTime(1,  pointOne, n);
        int startToTwo = getTiniestTime(1,  pointTwo, n);
        int oneToEnd = getTiniestTime(pointOne, n, n);
        int twoToEnd = getTiniestTime(pointTwo, n, n);

        if (oneToEnd == Integer.MAX_VALUE || twoToEnd == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            int starTo;
            int toEnd;
            if (startToOne+twoToEnd > startToTwo+oneToEnd) {
                starTo = startToTwo;
                toEnd = oneToEnd;
            } else  {
                starTo = startToOne;
                toEnd = twoToEnd;
            }

            System.out.println(starTo+eachPoint+toEnd);
        }
    }

    private static int getTiniestTime(int start, int end, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.time));

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.time != dist[poll.index]) {
                continue;
            }

            for (Node next : EDGES.get(poll.index)) {
                int newDist = poll.time + next.time;

                if (newDist < dist[next.index]) {
                    dist[next.index] = newDist;
                    queue.add(new Node(next.index, newDist));
                }
            }

        }

        return dist[end];
    }

    private static class Node {
        int index;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

}
