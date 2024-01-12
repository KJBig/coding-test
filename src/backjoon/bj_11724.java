package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_11724 {

    private static int[] visited;
    private static List<List<Integer>> edge = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int result = 0;
        visited = new int[N+1];

        for(int i=0; i<N+1; i++){
           edge.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            int f = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            edge.get(f).add(s);
            edge.get(s).add(f);
        }

        for(int i=1; i<N+1; i++){
            if(visited[i] == 0){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);

    }

    private static int dfs(int i) {
        if(visited[i] == 1){
            return 0;
        }
        visited[i] = 1;
        for(int j=0; j<edge.get(i).size(); j++){
            int target = edge.get(i).get(j);
            if(visited[target] == 0){
                dfs(target);
            }
        }
        return 0;
    }


}
