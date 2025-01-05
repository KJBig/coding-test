package backjoon.twenty_five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();

        while (queue.size() != 0 || !queue.isEmpty()) {
            Integer fPoll = queue.poll();
            if (fPoll == null) {
                break;
            }
            sb.append(fPoll).append("\n");
            Integer sPoll = queue.poll();
            if (sPoll == null) {
                break;
            }
            queue.add(sPoll);
        }

        System.out.println(sb);

    }

}
