package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ2660 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        while(true){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(a == -1 && b == -1){
                break;
            }

            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }

        int[] score = new int[n];
        int best = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int s = bfs(i, graph, n);
            score[i] = s;
            best = Math.min(best,s);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(score[i] == best){
                cnt++;
                sb.append(i+1).append(" ");
            }
        }

        System.out.println(best+" "+cnt);
        System.out.println(sb);
    }

    private static int bfs(int start, List<List<Integer>> graph, int n){
        int[] dist = new int[n];
        Arrays.fill(dist,-1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()){
            int poll = queue.poll();

            for(int next : graph.get(poll)){
                if(dist[next] != -1){
                    continue;
                }
                dist[next] = dist[poll]+1;
                queue.add(next);
            }
        }

        int maxDist = 0;
        for(int i=0; i<n; i++){
            maxDist = Math.max(maxDist,dist[i]);
        }

        return maxDist;
    }
}
