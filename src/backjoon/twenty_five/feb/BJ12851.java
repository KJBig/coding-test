package backjoon.twenty_five.feb;

import java.io.*;
import java.util.*;

public class BJ12851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int now = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int[] visited = new int[100001];

        if (now == target) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int answer = Integer.MAX_VALUE;
        int answerCount = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{now, 0});
        visited[now] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int location = poll[0];
            int oldTime = poll[1];
            for (int i=0; i<3; i++) {
                int next = location;
                int nowTime = oldTime+1;
                if (i == 0) {
                    next += 1;
                } else if (i == 1) {
                    next -= 1;
                } else {
                    next *= 2;
                }

                if (0<=next && next <= 100000) {
                    if (visited[next] != 0 && visited[next] < nowTime) {
                        continue;
                    }

                    visited[next] = nowTime;

                    if (next == target) {
                        if (nowTime < answer) {
                            answer = nowTime;
                            answerCount = 1;
                        } else if (nowTime == answer) {
                            answerCount++;
                        }
                    } else {
                        if (nowTime < answer) {
                            queue.add(new int[]{next, nowTime});
                        }
                    }
                }
            }
        }


        System.out.println(answer);
        System.out.println(answerCount);
    }
}
