package backjoon;

import java.io.*;
import java.util.*;
public class bj_1260 {

    private static List<List<Integer>> edge = new ArrayList<>();
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int V = Integer.parseInt(split[2]);

        visited = new int[N+1];
        
        for(int i=0; i<N+1; i++){
            edge.add(new ArrayList<>());
        }

        for(int i=1; i<=M; i++){
            String[] edgeInput = br.readLine().split(" ");
            int f = Integer.parseInt(edgeInput[0]);
            int s = Integer.parseInt(edgeInput[1]);

            edge.get(f).add(s);
            edge.get(s).add(f);
        }

        for(int i=1; i<=N; i++){
            edge.get(i).sort(Comparator.naturalOrder());
        }

        dfs(V);
        System.out.println();
        visited = new int[N+1];
        bfs(V);


    }
    
    public static int dfs(int i){
        if(visited[i] == 1){
            return 0;
        }
        visited[i] = 1;
        System.out.print(i + " ");
        for(int j=0; j<edge.get(i).size(); j++){
            dfs(edge.get(i).get(j));
        }
        return 0;
    }

    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            if(visited[poll] == 0){
                visited[poll] = 1;
                System.out.print(poll + " ");
            }
            for(int j=0; j<edge.get(poll).size(); j++){
                int target = edge.get(poll).get(j);
                if(visited[target] == 0){
                    queue.offer(target);
                }
            }
        }
    }
    
    
}
