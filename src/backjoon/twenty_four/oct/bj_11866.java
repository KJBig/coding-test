package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        List<Integer> numbers = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            numbers.add(i);
        }

        int now = K-1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (numbers.size() > 1) {
            Integer remove = numbers.remove(now);
            sb.append(remove).append(", ");
            now += K-1;
            if (now >= numbers.size()) {
                now %= numbers.size();
            }
        }
        sb.append(numbers.remove(0)).append(">");

        System.out.println(sb);


    }

}
