package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Long> poNums = new ArrayList<>();
        List<Long> neNums = new ArrayList<>();

        for (int i=0; i<N; i++) {
            long number = Long.parseLong(br.readLine());
            if (number > 0) {
                poNums.add(number);
            } else {
                neNums.add(number);
            }
        }

        int answer = 0;

        poNums.sort(Comparator.reverseOrder());
        neNums.sort(Comparator.naturalOrder());

        setNumbers(poNums);

        setNumbers(neNums);

        answer = addNumbers(poNums, answer);

        answer = addNumbers(neNums, answer);

        System.out.println(answer);

    }

    private static int addNumbers(List<Long> poNums, int answer) {
        for (int i = 0; i< poNums.size(); i++) {
            answer += poNums.get(i);
        }
        return answer;
    }

    private static void setNumbers(List<Long> poNums) {
        for (int i = 1; i< poNums.size(); i+=2) {
            Long start = poNums.get(i-1);
            Long end = poNums.get(i);
            if (end == 1) {
                i--;
                continue;
            }
            poNums.set(i-1, 0L);
            poNums.set(i, start*end);
        }
    }

}
