package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_15652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        dfs(N, M, 1, new ArrayList<>());
    }

    private static int dfs(int N, int M, int recent, List<Integer> array) {
        if(array.size() == M) {
            printArray(array);
            return 0;
        }

        for (int i=recent; i<=N; i++) {
            array.add(i);
            dfs(N, M, i, array);
            array.remove(array.size()-1);
        }

        return 0;
    }

    private static void printArray(List<Integer> array) {
        for (int i=0; i<array.size()-1; i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println(array.get(array.size()-1));
    }

}
