package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_15651 {

    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        dfs(N, M, 0, new ArrayList<>());
        System.out.print(SB.toString());
    }

    private static int dfs(int N, int M, int count, List<Integer> array) {
        if(count == M) {
            printArray(array);
            return 0;
        }

        for (int i=1; i<=N; i++) {
            array.add(i);
            dfs(N, M, count+1, array);
            array.remove(count);
        }

        return 0;
    }

    private static void printArray(List<Integer> array) {
        for (int i=0; i<array.size()-1; i++) {
            SB.append(array.get(i)).append(" ");;
        }
        SB.append(array.get(array.size()-1)).append("\n");
    }

}
