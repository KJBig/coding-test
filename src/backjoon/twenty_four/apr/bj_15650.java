package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_15650 {
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        bfs(1, 0, new ArrayList<>());

    }

    public static int bfs(int start, int size, List<Integer> list) {
        if (size == M) {
            printList(list);

            return 0;
        }

        for (int i=start; i<=N; i++) {
            list.add(i);
            bfs(i+1, size+1, list);
            list.remove(list.size()-1);
        }
        return 0;
    }

    private static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}