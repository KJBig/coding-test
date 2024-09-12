package backjoon.twenty_four.sep;

import java.io.*;
import java.util.*;
public class bj_14235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("0")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.poll()).append("\n");
            } else {
                int size = Integer.parseInt(split[0]);
                for (int j=1; j<=size; j++) {
                    queue.add(Integer.parseInt(split[j]));
                }
            }
        }



        System.out.println(sb.toString());

    }

}
