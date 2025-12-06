package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ1174 {
    static List<Long> ANSWERS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i=9; i>=0; i--) {
            numbers.add(i);
        }

        for (int i=1; i<=10; i++) {
            bfs(i, numbers, new ArrayList<>(), 0);
        }

        ANSWERS.sort(Comparator.naturalOrder());
        if (N > ANSWERS.size()) {
            System.out.println(-1);
        } else {
            System.out.println(ANSWERS.get(N - 1));
        }

    }

    private static void bfs(int size, List<Integer> numbers, List<Integer> now, int before) {
        if (now.size() == size) {
            StringBuilder sb = new StringBuilder();
            for (Integer number : now) {
                sb.append(number);
            }
            ANSWERS.add(Long.parseLong(sb.toString()));
            return;
        }

        for (int i=before; i<numbers.size(); i++) {
            now.add(numbers.get(i));
            bfs(size, numbers, now, i+1);
            now.remove(now.size()-1);
        }

    }
}
