package backjoon.twenty_five.nov;

import java.util.*;

public class PG12978 {
    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            int[] times = new int[N];
            HashMap<Integer, List<Node>> adjNodes = new HashMap<>();
            for (int i=0; i<N; i++) {
                times[i] = Integer.MAX_VALUE;
                adjNodes.put(i+1, new ArrayList<>());
            }

            for (int i=0; i<road.length; i++) {
                int start = road[i][0];
                int end = road[i][1];
                int time = road[i][2];
                adjNodes.get(start).add(new Node(time, end));
                adjNodes.get(end).add(new Node(time, start));
            }

            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.time));
            queue.add(new Node(0, 1));
            times[0] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                List<Node> nodes = adjNodes.get(node.nodeIndex);
                for (int i=0; i<nodes.size(); i++) {
                    Node adjNode = nodes.get(i);
                    if (times[adjNode.nodeIndex-1] == Integer.MAX_VALUE) {
                        times[adjNode.nodeIndex-1] = times[node.nodeIndex-1]+adjNode.time;
                        queue.add(adjNode);
                    } else {
                        if (times[adjNode.nodeIndex-1] > times[node.nodeIndex-1]+adjNode.time) {
                            times[adjNode.nodeIndex-1] = times[node.nodeIndex-1]+adjNode.time;
                            queue.add(adjNode);
                        }
                    }
                }


            }

            for (int i=0; i<N; i++) {
                if (times[i] <= K) {
                    answer++;
                }
            }

            return answer;
        }

        class Node {
            int time;
            int nodeIndex;

            public Node (int time, int nodeIndex) {
                this.time = time;
                this.nodeIndex = nodeIndex;
            }
        }
    }
}
