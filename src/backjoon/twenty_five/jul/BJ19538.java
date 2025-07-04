package backjoon.twenty_five.jul;

import java.io.*;
import java.util.*;

public class BJ19538 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i + 1));
        }

        Queue<int[]> liars = new LinkedList<>();
        int[] times = new int[N];
        Arrays.fill(times, -1);

        for (int i = 0; i < N; i++) {
            Node nowNode = nodes.get(i);
            String[] input = br.readLine().split(" ");
            for (String s : input) {
                int nowNumber = Integer.parseInt(s);
                if (nowNumber == 0) break;
                Node targetNode = nodes.get(nowNumber - 1);
                nowNode.adjoints.add(targetNode);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (String s : input) {
            int nowNumber = Integer.parseInt(s);
            Node nowNode = nodes.get(nowNumber - 1);
            times[nowNumber - 1] = 0;
            nowNode.isLiar = true;
            liars.add(new int[]{nowNumber, 0});
        }

        while (!liars.isEmpty()) {
            int[] poll = liars.poll();
            Node node = nodes.get(poll[0] - 1);
            int curTime = poll[1];

            for (Node neighbor : node.adjoints) {
                neighbor.liarCount++;
            }

            for (Node neighbor : node.adjoints) {
                if (times[neighbor.index - 1] == -1 &&
                        neighbor.liarCount >= Math.ceil(neighbor.adjoints.size() / 2.0)) {
                    times[neighbor.index - 1] = curTime + 1;
                    neighbor.isLiar = true;
                    liars.add(new int[]{neighbor.index, curTime + 1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int time : times) {
            sb.append(time).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static class Node {
        public int index;
        public boolean isLiar = false;
        public int liarCount = 0;
        public List<Node> adjoints = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }
    }
}
