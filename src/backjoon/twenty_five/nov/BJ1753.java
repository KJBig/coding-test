package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int[] len = new int[V];
        for (int i=0; i<V; i++) {
            len[i] = Integer.MAX_VALUE;
        }

        int K = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Node>> hashMap = new HashMap<>();

        for (int i=0; i<V; i++) {
            hashMap.put(i+1, new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            String[] eInput = br.readLine().split(" ");
            int start = Integer.parseInt(eInput[0]);
            int end = Integer.parseInt(eInput[1]);
            int length = Integer.parseInt(eInput[2]);
            hashMap.get(start).add(new Node(length, end));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.length));
        queue.add(new Node(0, K));
        len[K-1] = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> nodes = hashMap.get(poll.targetIndex);

            for (int i=0; i<nodes.size(); i++) {
                Node nowNode = nodes.get(i);
                int nextLen = poll.length+nowNode.length;
                if (len[nowNode.targetIndex-1] > nextLen) {
                    len[nowNode.targetIndex-1] = nextLen;
                    queue.add(new Node(len[nowNode.targetIndex-1], nowNode.targetIndex));
                }
            }

        }

        for (int i=0; i<V; i++) {
            if (len[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(len[i]);
            }
        }

    }

    static class Node {
        int length;
        int targetIndex;

        public Node (int length, int targetIndex) {
            this.length=length;
            this.targetIndex=targetIndex;
        }
    }
}
