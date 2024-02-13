package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class bj_2798 {
    private static int MAX_NUMBER = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        List<Integer> cards = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        dfs(N, M, cards, new ArrayList<>(), 0);
        System.out.println(MAX_NUMBER);
    }

    private static int dfs(int n, int m, List<Integer> cards, List<Integer> pick, int start) {
        if(pick.size() == 3){
            int pickSumNumber = sumPick(pick);
            if(pickSumNumber <= m){
                MAX_NUMBER = Math.max(MAX_NUMBER, pickSumNumber);
            }
            return 0;
        }

        for(int i=start; i<n; i++){
            pick.add(cards.get(i));
            dfs(n, m, cards, pick, i+1);
            pick.remove(pick.size() - 1);
        }
        return 0;
    }

    private static int sumPick(List<Integer> pick) {
        int result = 0;
        for (Integer integer : pick) {
            result += integer;
        }
        return result;
    }
}