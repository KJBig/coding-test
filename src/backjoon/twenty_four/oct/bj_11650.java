package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class bj_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            Node node = new Node(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            nodes.add(node);
        }

        nodes.sort(Comparator.comparing(Node::getX).thenComparing(Node::getY));

        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.getX()).append(" ").append(node.getY()).append("\n");
        }

        System.out.println(sb);
    }

    static class Node {

        private int x;
        private int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

    }
}
