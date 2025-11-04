package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.start));
        PriorityQueue<Node> classRooms = new PriorityQueue<>(Comparator.comparing(n -> n.end));
        int N = Integer.parseInt(br.readLine());
        
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            queue.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }


        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            
            if (classRooms.isEmpty()) {
                classRooms.add(poll);
            } else {
                Node peek = classRooms.peek();
                
                if (poll.start >= peek.end) {
                    classRooms.poll();
                    classRooms.add(poll);
                } else {
                    classRooms.add(poll);
                }
            }

        }

        System.out.println(classRooms.size());


    }

    static class Node {
        int start;
        int end;
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
