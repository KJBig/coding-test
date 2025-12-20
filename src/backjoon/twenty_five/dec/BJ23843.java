package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ23843 {
    static int N;
    static int M;
    static Integer[] ELECTRONICS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ELECTRONICS = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ELECTRONICS[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ELECTRONICS, Collections.reverseOrder());

        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if (queue.size() >= M) {
                time = queue.poll();
            }
            queue.add(time + ELECTRONICS[i]);
        }

        while (!queue.isEmpty()) {
            time = queue.poll();
        }

        System.out.println(time);

    }

}
