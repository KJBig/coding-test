package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ12869 {
    static int[][] DAMAGES = {
            {9, 3, 1}, {9, 1, 3}, {3, 9, 1},
            {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
    };
    static int[][][] VISITED = new int[61][61][61];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] scv = new int[3];
        String[] initHp = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            scv[i] = Integer.parseInt(initHp[i]);
        }

        System.out.println(bfs(scv));
    }

    static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start[0]][start[1]][start[2]] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int s1 = poll[0];
            int s2 = poll[1];
            int s3 = poll[2];

            if (s1==0 && s2==0 && s3==0) {
                return VISITED[s1][s2][s3] - 1;
            }

            for (int i=0; i<6; i++) {
                int ns1 = Math.max(0, s1 - DAMAGES[i][0]);
                int ns2 = Math.max(0, s2 - DAMAGES[i][1]);
                int ns3 = Math.max(0, s3 - DAMAGES[i][2]);

                if (VISITED[ns1][ns2][ns3] == 0) {
                    VISITED[ns1][ns2][ns3] = VISITED[s1][s2][s3] + 1;
                    queue.add(new int[]{ns1, ns2, ns3});
                }
            }
        }
        return -1;
    }
}