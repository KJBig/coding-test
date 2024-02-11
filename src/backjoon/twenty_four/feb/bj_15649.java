package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_15649 {
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        visited = new int[N];

        dfs(N, M, 0, new ArrayList<>());

    }

    private static int dfs(int N, int M, int deep, List<Integer> result){
        if(deep == M){
            printList(result);
            return 0;
        }

        for(int i=0; i<N; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                result.add(i+1);
                dfs(N, M, deep+1, result);
                visited[i] = 0;
                result.remove(result.size()-1);
            }
        }
        return 0;
    }

    private static void printList(List<Integer> result) {
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
