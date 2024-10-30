package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_1182 {

    static boolean[] VISITED;
    static int ANSWER = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] numbers = new int[N];
        VISITED = new boolean[N];
        String[] numberInput = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(numberInput[i]);
            numbers[i] = number;
        }
        for (int size=1; size<=N; size++) {
            dfs(numbers, M, size, new ArrayList<>(), 0);
        }

        System.out.println(ANSWER);
    }

    private static void dfs(int[] numbers, int M, int size, List<Integer> nowNum, int start) {
        if (nowNum.size() == size) {
            if (getSum(nowNum) == M) {
                ANSWER++;
            }
            return;
        }

        for (int i=start; i<numbers.length; i++) {
            if (!VISITED[i]) {
                nowNum.add(numbers[i]);
                VISITED[i] = true;
                dfs(numbers, M, size, nowNum, i);
                VISITED[i] = false;
                nowNum.remove(nowNum.size()-1);
            }
        }

    }

    private static int getSum(List<Integer> nowNum) {
        int sum = 0;
        for (Integer integer : nowNum) {
            sum += integer;
        }
        return sum;
    }

}