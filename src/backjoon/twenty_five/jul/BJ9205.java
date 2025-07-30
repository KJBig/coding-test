package backjoon.twenty_five.jul;

import java.io.*;
import java.util.*;

public class BJ9205 {
    static int START_X, START_Y, END_X, END_Y, STORE_SIZE;
    static boolean[] VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=0; testCase<T; testCase++) {
            STORE_SIZE = Integer.parseInt(br.readLine());
            String[] startData = br.readLine().split(" ");
            START_X = Integer.parseInt(startData[0]);
            START_Y = Integer.parseInt(startData[1]);

            List<int[]> storeLocs = new ArrayList<>();
            VISITED = new boolean[STORE_SIZE];
            for (int i=0; i<STORE_SIZE; i++) {
                String[] storeLocData = br.readLine().split(" ");
                int storeLocX = Integer.parseInt(storeLocData[0]);
                int storeLocY = Integer.parseInt(storeLocData[1]);
                storeLocs.add(new int[]{storeLocX, storeLocY});
            }
            String[] endData = br.readLine().split(" ");
            END_X = Integer.parseInt(endData[0]);
            END_Y = Integer.parseInt(endData[1]);

            boolean result = bfs(storeLocs);

            if (result) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static boolean bfs(List<int[]> stores) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{START_X, START_Y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            if ((Math.abs(nowX-END_X) + Math.abs(nowY-END_Y)) <= 1000) {
                return true;
            }

            for (int i=0; i<STORE_SIZE; i++) {
                if (!VISITED[i]) {
                    int[] storeLoc = stores.get(i);
                    if ((Math.abs(nowX-storeLoc[0]) + Math.abs(nowY-storeLoc[1])) <= 1000) {
                        queue.add(new int[]{storeLoc[0], storeLoc[1]});
                        VISITED[i]=true;
                    }
                }
            }

        }

        return false;

    }
}
