package backjoon.twenty_five.apr;

import java.util.*;
import java.io.*;

public class BJ13913 {
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
        } else {
            bfs(N, K);
            System.out.println(time[K]-1);

            Stack<Integer> stack = new Stack<>();
            stack.push(K);
            int index = K;
            while (index!=N){
                stack.push(parent[index]);
                index = parent[index];
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);
        }

    }

    private static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (now == K) return;

            if (now * 2 <= 100000 && time[now * 2] == 0) {
                time[now * 2] = time[now] + 1;
                parent[now * 2] = now;
                queue.add(now * 2);
            }
            if (now + 1 <= 100000 && time[now + 1] == 0) {
                time[now + 1] = time[now] + 1;
                parent[now + 1] = now;
                queue.add(now + 1);
            }
            if (now - 1 >= 0 && time[now - 1] == 0) {
                time[now - 1] = time[now] + 1;
                parent[now - 1] = now;
                queue.add(now - 1);
            }
        }
    }

}
