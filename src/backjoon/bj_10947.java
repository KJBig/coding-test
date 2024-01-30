package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_10947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }
        dfs(list, new ArrayList<>());
    }

    private static int dfs(List<Integer> list, List<Integer> result) {
        if(list.isEmpty()){
            printList(result);
            return 0;
        }
        for(int i=0; i<list.size(); i++){
            Integer integer = list.remove(i);
            result.add(integer);
            dfs(list, result);
            Integer remove = result.remove(result.size() - 1);
            list.add(i, remove);
        }
        return 0;

    }

    private static void printList(List<Integer> result) {
        for (int i=0; i<result.size()-1; i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println(result.get(result.size()-1));
    }
}
