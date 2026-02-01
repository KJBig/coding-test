package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> nodes = new ArrayList<>();
        int[][] BOARD = new int[N][N];

        for (int i=0; i<N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i=0; i<N; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                if (Integer.parseInt(boardInput[j]) == 1) {
                    nodes.get(i).add(j);
                }
            }
        }

        for (int i=0; i<N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            BOARD[i][i] = 1;

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (Integer adjNode : nodes.get(poll)) {
                    if (BOARD[i][adjNode] != 1) {
                        BOARD[i][adjNode] = 1;
                        queue.add(adjNode);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(BOARD[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
