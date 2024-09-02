package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj_14888 {

    static int[] NUMBERS;
    static int[] VISITED;
    static int[] SIG;
    static int MAX_NUM = Integer.MIN_VALUE;
    static int MIN_NUM = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int totalSize = Integer.parseInt(br.readLine());

        NUMBERS = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sigNums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        SIG = new int[totalSize-1];
        VISITED = new int[totalSize-1];
        int now = 0;
        for (int i=0; i<sigNums.length; i++) {
            for (int j=0; j<sigNums[i]; j++) {
                SIG[now] = i;
                now++;
            }
        }

        dfs(0, new ArrayList<>());


        System.out.println(MAX_NUM);
        System.out.println(MIN_NUM);
    }

    private static int dfs(int level, List<Integer> array) {
        if (level == SIG.length) {
            int number = calNumber(array);
            MAX_NUM = Math.max(MAX_NUM, number);
            MIN_NUM = Math.min(MIN_NUM, number);
            return 0;
        }

        for(int i=0; i<SIG.length; i++) {
            if (VISITED[i] == 0) {
                array.add(SIG[i]);
                VISITED[i] = 1;
                dfs(level+1, array);
                array.remove(array.size()-1);
                VISITED[i] = 0;
            }
        }

        return 0;
    }

    private static int calNumber(List<Integer> array) {
        int answer = NUMBERS[0];
        for (int i=1; i<NUMBERS.length; i++) {
            answer = getNumber(answer, NUMBERS[i], array.get(i-1));
        }
        return answer;
    }

    private static int getNumber(int answer, int nextNum, Integer flag) {
        if (flag == 0) {
            answer += nextNum;
        }
        if (flag == 1) {
            answer -= nextNum;
        }
        if (flag == 2) {
            answer *= nextNum;
        }
        if (flag == 3) {
            answer /= nextNum;
        }
        return answer;
    }
}
