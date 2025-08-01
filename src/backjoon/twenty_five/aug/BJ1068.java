package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ1068 {
    static Node[] NODES;
    static int DELETE_INDEX;
    static int LEAF_COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        NODES = new Node[N];

        for (int i = 0; i < N; i++) {
            NODES[i] = new Node();
            NODES[i].index = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                NODES[parent].children.add(NODES[i]);
            }
        }

        DELETE_INDEX = Integer.parseInt(br.readLine());

        if (DELETE_INDEX == root) {
            System.out.println(0);
        } else {
            dfs(NODES[root]);
            System.out.println(LEAF_COUNT);
        }
    }

    static void dfs(Node node) {
        if (node.index == DELETE_INDEX) return;

        if (node.children.isEmpty() || node.children.stream().allMatch(child -> child.index == DELETE_INDEX)) {
            LEAF_COUNT++;
            return;
        }

        for (Node child : node.children) {
            if (child.index != DELETE_INDEX) {
                dfs(child);
            }
        }
    }

    static class Node {
        int index;
        List<Node> children = new ArrayList<>();
    }
}