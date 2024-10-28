package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class bj_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> numbers = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            numbers.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        numbers.sort(Comparator.comparing(Node::getY).thenComparing(Node::getX));


        StringBuilder sb = new StringBuilder();

        for (Node number : numbers) {
            sb.append(number.getX()).append(" ").append(number.getY()).append("\n");
        }

        System.out.println(sb);

    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

    }
}
