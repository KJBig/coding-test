package backjoon;

import java.io.*;
import java.util.*;
public class bj_2606 {
    private static List<List<Integer>> edge = new ArrayList<>();
    private static int[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        for(int i=0; i<=V; i++){
            edge.add(new ArrayList<>());
        }

        visited = new int[V+1];

        for (int i=0; i<E; i++){
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            edge.get(start).add(end);
            edge.get(end).add(start);
        }

        System.out.println(bfs(1));

    }

    private static int bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = 1;
        int count = 0;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for(int i=0; i<edge.get(poll).size(); i++){
                int target = edge.get(poll).get(i);
                if(visited[target] == 0) {
                    visited[target] = 1;
                    queue.offer(target);
                    count++;
                }
            }
        }
        return count;
    }
}
