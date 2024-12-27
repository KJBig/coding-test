package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BJ1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int tesu = Integer.parseInt(inputs[1]);
        int rankSize = Integer.parseInt(inputs[2]);

        List<Integer> numbers = new ArrayList<>();
        int[] ranks = new int[N+1];
        String[] numberInput = new String[N];
        if (N != 0) {
            numberInput = br.readLine().split(" ");
        }
        for (int i=0; i<N; i++) {
            numbers.add(Integer.parseInt(numberInput[i]));
        }

        numbers.add(tesu);

        numbers.sort(Comparator.reverseOrder());
        ranks[0] = 1;
        for (int i=1; i<N+1; i++) {
            if (Objects.equals(numbers.get(i), numbers.get(i - 1))) {
                ranks[i] = ranks[i-1];
            } else {
                ranks[i] = i+1;
            }
        }
        int lastIndex = numbers.lastIndexOf(tesu);

        int answer;
        if (lastIndex >= rankSize) {
            answer = -1;
        } else {
            answer = ranks[lastIndex];
        }

        System.out.println(answer);
    }
}
