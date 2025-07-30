package backjoon.twenty_five.jul;

import java.io.*;
import java.util.*;

public class BJ1389 {
    static int[][] SCORE;
    static List<List<Integer>> MATCH = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            MATCH.add(new ArrayList<>());
        }
        SCORE = new int[N][N];

        for (int i=0; i<M; i++) {
            String[] matchData = br.readLine().split(" ");
            int front = Integer.parseInt(matchData[0]);
            int back = Integer.parseInt(matchData[1]);
            MATCH.get(front-1).add(back-1);
            MATCH.get(back-1).add(front-1);
        }

        for (int i=0; i<N; i++) {
            bfs(i);
        }


        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i=0; i<N; i++) {
            int[] scores = SCORE[i];
            int nowValue = 0;
            for (int j=0; j<N; j++) {
                nowValue += scores[j];
            }
            if (minValue > nowValue) {
                minValue = nowValue;
                minIndex = i;
            }
        }

        System.out.println(minIndex+1);
    }

    static void bfs(int i) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int count = poll[1];
            List<Integer> matches = MATCH.get(index);
            for (Integer match : matches) {
                if (match == i) {
                    continue;
                }
                if (SCORE[i][match] == 0) {
                    SCORE[i][match] = count+1;
                    queue.add(new int[]{match, count+1});
                }
            }
        }
    }
}
