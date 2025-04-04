package backjoon.twenty_five.apr;

import java.io.*;
import java.util.*;

public class BJ13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int minCount = Integer.MAX_VALUE;
        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            visited[poll[0]] = true;

            if (poll[0] == K) {
                minCount = Math.min(minCount, poll[1]);
            }
            if (poll[0]*2 <= 100000 && !visited[poll[0]*2]) {
                queue.add(new int[]{poll[0]*2, poll[1]});
            }
            if (poll[0]+1 <= 100000 && !visited[poll[0]+1]) {
                queue.add(new int[]{poll[0]+1, poll[1]+1});
            }
            if (0<=poll[0]-1 && !visited[poll[0]-1]) {
                queue.add(new int[]{poll[0]-1, poll[1]+1});
            }
        }

        System.out.println(minCount);

    }
}
