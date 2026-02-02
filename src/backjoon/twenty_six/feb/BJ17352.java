package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ17352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> nodes = new ArrayList<>();
        boolean[] canGo = new boolean[N];

        for (int i=0; i<N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i=0; i<N-2; i++) {
            String[] brInput = br.readLine().split(" ");
            int start = Integer.parseInt(brInput[0]);
            int end = Integer.parseInt(brInput[1]);

            nodes.get(start-1).add(end-1);
            nodes.get(end-1).add(start-1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        canGo[0] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : nodes.get(poll)) {
                boolean flag = false;
                if (!canGo[integer]) {
                    canGo[integer] = true;
                    queue.add(integer);
                }
            }
        }

        for (int i=0; i<N; i++) {
            if (!canGo[i]) {
                System.out.println("1" + " " + (i+1));
                return;
            }
        }

    }
}
