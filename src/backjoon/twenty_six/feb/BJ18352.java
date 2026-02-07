package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);
        int K = Integer.parseInt(initInput[2]);
        int X = Integer.parseInt(initInput[3]);

        List<List<Integer>> nodes = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            String[] roadInput = br.readLine().split(" ");
            int start = Integer.parseInt(roadInput[0]);
            int end = Integer.parseInt(roadInput[1]);
            nodes.get(start).add(end);
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        visited[X] = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : nodes.get(poll)) {
                if (visited[i] == -1) {
                    visited[i] = visited[poll] + 1;
                    queue.add(i);
                } else {
                    if (visited[i] > visited[poll] + 1) {
                        visited[i] = visited[poll] + 1;
                        queue.add(i);
                    }
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<visited.length; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }

        answer.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (Integer i : answer) {
            sb.append(i).append("\n");
        }

        if (answer.isEmpty()) {
            sb.append(-1);
        }
        System.out.println(sb);
    }
}
