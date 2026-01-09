package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ9019 {
    static final int MAX = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            String[] initInput = br.readLine().split(" ");
            int start = Integer.parseInt(initInput[0]);
            int end = Integer.parseInt(initInput[1]);

            out.append(bfs(start, end)).append('\n');
        }

        System.out.print(out);
    }

    static String bfs(int start, int end) {
        boolean[] visited = new boolean[MAX];
        int[] prev = new int[MAX];
        char[] how = new char[MAX];

        Arrays.fill(prev, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                break;
            }

            // D
            int next = (cur * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                prev[next] = cur;
                how[next] = 'D';
                queue.add(next);
            }

            // S
            next = (cur == 0) ? 9999 : cur - 1;
            if (!visited[next]) {
                visited[next] = true;
                prev[next] = cur;
                how[next] = 'S';
                queue.add(next);
            }

            // L
            next = (cur % 1000) * 10 + (cur / 1000);
            if (!visited[next]) {
                visited[next] = true;
                prev[next] = cur;
                how[next] = 'L';
                queue.add(next);
            }

            // R
            next = (cur % 10) * 1000 + (cur / 10);
            if (!visited[next]) {
                visited[next] = true;
                prev[next] = cur;
                how[next] = 'R';
                queue.add(next);
            }
        }

        // 역추적
        StringBuilder sb = new StringBuilder();
        int cur = end;
        while (cur != start) {
            sb.append(how[cur]);
            cur = prev[cur];
        }

        return sb.reverse().toString();
    }
}
