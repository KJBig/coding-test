package backjoon.twenty_four.oct;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bj_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] VISITED = new int[N+1];
        List<List<Integer>> nodes = new ArrayList<>();
        int[] answer = new int[N+1];

        for (int i=0; i<N+1; i++){
            nodes.add(new ArrayList<>());
        }

        for (int row=0; row<N-1; row++){
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            nodes.get(start).add(end);
            nodes.get(end).add(start);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        VISITED[1] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : nodes.get(poll)) {
                if (VISITED[integer] == 0) {
                    queue.add(integer);
                    VISITED[integer] = 1;
                    answer[integer] = poll;
                }
            }
        }

        for (int i=2; i<N+1; i++) {
            System.out.println(answer[i]);
        }


    }

}
