package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj_2309 {
    private static int[] numbers = new int[9];
    private static int[] VISITED = new int[9];
    private static int[] RESULT = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        dfs(new ArrayList<>(), 0);
        int[] array = Arrays.stream(RESULT).sorted().toArray();
        for (int i : array) {
            System.out.println(i);
        }

    }

    private static int dfs(List<Integer> result, int now) {
        if(result.size() == 7){
            if (getSum(result) == 100) {
                setResult(result);
            }
            return 0;
        }

        for (int i=now; i<9; i++) {
            if(VISITED[i] == 0) {
                VISITED[i] = 1;
                result.add(numbers[i]);
                dfs(result, now + 1);
                result.remove(result.size() - 1);
                VISITED[i] = 0;
            }
        }
        return 0;

    }

    private static void setResult(List<Integer> result) {
        for (int i=0; i<7; i++) {
            RESULT[i] = result.get(i);
        }
    }

    private static int getSum(List<Integer> result) {
        int sum = 0;
        for (Integer integer : result) {
            sum+=integer;
        }
        return sum;
    }
}
