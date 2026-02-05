package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ2529 {

    static boolean[] VISITED;
    static String[] SIGNS;
    static String MAX_VALUE = "-1";
    static String MIN_VALUE = String.valueOf(Long.MAX_VALUE);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SIGNS = br.readLine().split(" ");
        VISITED = new boolean[10];


        for (int i=0; i<=9; i++) {
            VISITED[i] = true;
            List<Integer> numbers = new ArrayList<>();
            numbers.add(i);
            bfs(N, numbers);
            numbers.remove(numbers.size()-1);
            VISITED[i] = false;
        }

        System.out.println(MAX_VALUE);
        System.out.println(MIN_VALUE);

    }

    private static void bfs(int count, List<Integer> numbers) {
        if (numbers.size() == count+1) {
            StringBuilder sb = new StringBuilder();
            for (Integer number : numbers) {
                sb.append(number);
            }
            long value = Long.parseLong(sb.toString());

            if (Long.parseLong(MAX_VALUE) < value) {
                MAX_VALUE = sb.toString();
            }
            if (Long.parseLong(MIN_VALUE) > value) {
                MIN_VALUE = sb.toString();
            }

            return;
        }

        for (int i=0; i<=9; i++) {
            if (!VISITED[i] && canAppend(numbers.get(numbers.size()-1), i, numbers.size()-1)) {
                VISITED[i] = true;
                numbers.add(i);
                bfs(count, numbers);
                numbers.remove(numbers.size()-1);
                VISITED[i] = false;
            }
        }
    }

    private static boolean canAppend(int prev, int next, int index) {
        String sign = SIGNS[index];

        if (sign.equals("<")) {
            return prev < next;
        } else {
            return prev > next;
        }

    }
}
