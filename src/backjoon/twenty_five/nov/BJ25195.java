package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ25195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] edgeInput = br.readLine().split(" ");
            int start = Integer.parseInt(edgeInput[0]) - 1;
            int end = Integer.parseInt(edgeInput[1]) - 1;
            adj.get(start).add(end);
        }

        int fanSize = Integer.parseInt(br.readLine());
        boolean[] isFans = new boolean[N];
        String[] fanLoc = br.readLine().split(" ");
        for (int i = 0; i < fanSize; i++) {
            int fan = Integer.parseInt(fanLoc[i]) - 1;
            isFans[fan] = true;
        }

        boolean answer = true;

        Queue<Integer> queue = new LinkedList<>();;
        if (!isFans[0]) {
            queue.add(0);
            visited[0] = true;
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> pollAdj = adj.get(poll);
            if (pollAdj.isEmpty()) {
                answer = false;
                queue.clear();
                continue;
            }
            for (Integer nxt : pollAdj) {
                if (!visited[nxt]) {
                    if (!isFans[nxt]) {
                        visited[nxt] = true;
                        queue.add(nxt);
                    }
                }
            }
        }

        if (answer) {
            System.out.println("Yes");
        } else {
            System.out.println("yes");
        }
    }
}
