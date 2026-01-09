package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];
        int[] pre = new int[n+1];
        int[] how = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (poll == 1) {
                break;
            }

            if (poll%3 == 0) {
                int next = poll/3;
                if (!visited[next]) {
                    visited[next] = true;
                    pre[next] = poll;
                    how[next] = 1;
                    queue.add(next);
                }
            }

            if (poll%2 == 0) {
                int next = poll/2;
                if (!visited[next]) {
                    visited[next] = true;
                    pre[next] = poll;
                    how[next] = 2;
                    queue.add(next);
                }
            }

            int next = poll-1;
            if (!visited[next]) {
                visited[next] = true;
                pre[next] = poll;
                how[next] = 3;
                queue.add(next);
            }
        }

        // 출력
        int now = 1;
        List<Integer> method = new ArrayList<>();
        while (now != n) {
            method.add(how[now]);
            now = pre[now];
        }

        Collections.reverse(method);

        System.out.println(method.size());
        StringBuilder sb = new StringBuilder();

        int initValue = n;
        sb.append(initValue).append(" ");
        for (Integer i : method) {
            if (i == 1) {
                initValue /= 3;
            }

            if (i == 2) {
                initValue /= 2;
            }

            if (i == 3) {
                initValue -= 1;
            }

            sb.append(initValue).append(" ");
        }

        System.out.println(sb);

    }
}
