package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_15657 {
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        List<Integer> numbers = new ArrayList<>();
        String[] numberInput = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            numbers.add(Integer.parseInt(numberInput[i]));
        }
        numbers.sort(Comparator.naturalOrder());

        bfs(numbers, new ArrayList<>(), M, 0);

        System.out.println(SB);
    }

    private static void bfs(List<Integer> numbers, List<Integer> now, int M, int index) {
        if (index == M) {
            printAnswer(now);
            return;
        }

        for (int i=0; i<numbers.size(); i++) {
            if (now.size() == 0 || (now.get(now.size()-1) <= numbers.get(i))) {
                now.add(numbers.get(i));
                bfs(numbers, now, M, index+1);
                now.remove(now.size()-1);
            }
        }
    }

    private static void printAnswer(List<Integer> now) {
        for (int i=0; i<now.size(); i++) {
            SB.append(now.get(i)).append(" ");
        }
        SB.append("\n");
    }
}
