package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> board = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            board.add(List.of(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        Collections.sort(board, Comparator.comparingInt(o -> o.get(0)));
        int answer = 0;
        int start = board.get(0).get(0);
        int end = board.get(0).get(1);

        for (int i=1; i<N; i++) {
            if (board.get(i).get(0) > end) {
                answer += (end - start);
                start = board.get(i).get(0);
                end = board.get(i).get(1);
            } else {
                if (end < board.get(i).get(1)) {
                    end = board.get(i).get(1);
                }
            }
        }

        answer += (end-start);

        System.out.println(answer);
    }
}
