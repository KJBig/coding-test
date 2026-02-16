package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ18223 {

    static int V, E, P;
    static List<List<Node>> NODES = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        V = Integer.parseInt(initInput[0]);
        E = Integer.parseInt(initInput[1]);
        P = Integer.parseInt(initInput[2]);

        for (int i=0; i<=V; i++) {
            NODES.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            String[] nodeInput = br.readLine().split(" ");
            int a = Integer.parseInt(nodeInput[0]);
            int b = Integer.parseInt(nodeInput[1]);
            int c = Integer.parseInt(nodeInput[2]);

            NODES.get(a).add(new Node(b, c));
            NODES.get(b).add(new Node(a, c));
        }

        VisitData[] visited = new VisitData[V+1];
        for (int i=1; i<=V; i++) {
            visited[i] = new VisitData();
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.value));

        visited[1].value = 0;
        if (P == 1) {
            visited[1].isSave = true;
        }
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.value > visited[poll.index].value) {
                continue;
            }

            for (Node next : NODES.get(poll.index)) {
                int nextDistance = visited[poll.index].value + next.value;

                if (visited[next.index].value == -1 || visited[next.index].value > nextDistance) {
                    visited[next.index].value = nextDistance;
                    visited[next.index].isSave = (visited[poll.index].isSave || next.index == P);
                    queue.add(new Node(next.index, nextDistance));
                }
                else if (visited[next.index].value == nextDistance) {
                    if (!visited[next.index].isSave && (visited[poll.index].isSave || next.index == P)) {
                        visited[next.index].isSave = true;
                        queue.add(new Node(next.index, nextDistance));
                    }
                }
            }
        }

        if (visited[V].isSave) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }

    }

    private static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class VisitData {
        int value;
        boolean isSave;

        public VisitData() {
            this.value = -1;
            this.isSave = false;
        }
    }
}
