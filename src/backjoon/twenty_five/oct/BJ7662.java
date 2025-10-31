package backjoon.twenty_five.oct;

import java.io.*;
import java.util.*;

public class BJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testIndex=0; testIndex<T; testIndex++) {
            int Q = Integer.parseInt(br.readLine());
            PriorityQueue<Node> maxQueue = new PriorityQueue<>(Comparator.comparing(n -> n.value, Comparator.reverseOrder()));
            PriorityQueue<Node> minQueue = new PriorityQueue<>(Comparator.comparing(n -> n.value));
            boolean[] alive = new boolean[Q];
            int nodeIndex = 0;

            for (int commandIndex=0; commandIndex<Q; commandIndex++) {
                String[] commands = br.readLine().split(" ");
                String command = commands[0];
                int number = Integer.parseInt(commands[1]);
                if (command.equals("I")) {
                    insertCommand(number, nodeIndex, maxQueue, minQueue, alive);
                    nodeIndex++;
                }
                if (command.equals("D")) {
                    deleteCommand(number, maxQueue, minQueue, alive);
                }
            }
            printAnswer(maxQueue, minQueue, alive);
        }
    }

    private static void deleteCommand(int number, PriorityQueue<Node> maxQueue, PriorityQueue<Node> minQueue, boolean[] alive) {
        if (number == 1) {
            Node poll;
            do {
                if (maxQueue.isEmpty()) {
                    return;
                }
                poll = maxQueue.poll();
            } while (!alive[poll.id]);
            alive[poll.id] = false;
        }
        if (number == -1) {
            Node poll;
            do {
                if (minQueue.isEmpty()) {
                    return;
                }
                poll = minQueue.poll();
            } while (!alive[poll.id]);
            alive[poll.id] = false;
        }
    }

    private static void insertCommand(int number, int nodeIndex, PriorityQueue<Node> maxQueue, PriorityQueue<Node> minQueue, boolean[] alive) {
        Node node = new Node(number, nodeIndex);
        maxQueue.add(node);
        minQueue.add(node);
        alive[nodeIndex] = true;
    }

    private static void printAnswer(PriorityQueue<Node> maxQueue, PriorityQueue<Node> minQueue, boolean[] alive) {
        Node max;
        Node min;

        do {
            if (maxQueue.isEmpty()) {
                System.out.println("EMPTY");
                return;
            }
            max = maxQueue.poll();
        } while (!alive[max.id]);

        do {
            if (minQueue.isEmpty()) {
                System.out.println("EMPTY");
                return;
            }
            min = minQueue.poll();
        } while (!alive[min.id]);

        System.out.println(max.value + " " + min.value);

    }

    static class Node {

        int value;
        int id;

        public Node(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }
}
