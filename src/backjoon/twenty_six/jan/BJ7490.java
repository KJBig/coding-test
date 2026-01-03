package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ7490 {

    static List<String> ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=0; testCase<T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            ANSWER = new ArrayList<>();
            for (int i=1; i<=N; i++) {
                List<Integer> number = new ArrayList<>();
                number.add(i);
                dfs(i+1, N, number, new ArrayList<>());
            }

            printAnswer();
        }

    }

    private static void dfs(int start, int n, List<Integer> numbers, List<String> signs) {
        if (n == numbers.size()) {
            int totalValue = calTotalValue(numbers, signs);
            if (totalValue == 0) {
                addAnswer(numbers, signs);
            }
            return;
        }

        for (int i=start; i<=n; i++) {
            numbers.add(i);

            signs.add("+");
            dfs(i+1, n, numbers, signs);
            signs.remove(signs.size()-1);

            signs.add("-");
            dfs(i+1, n, numbers, signs);
            signs.remove(signs.size()-1);

            signs.add(" ");
            dfs(i+1, n, numbers, signs);
            signs.remove(signs.size()-1);

            numbers.remove(numbers.size()-1);

        }

    }

    private static void addAnswer(List<Integer> numbers, List<String> signs) {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers.get(0));
        for (int i=1; i<numbers.size(); i++) {
            sb.append(signs.get(i-1));
            sb.append(numbers.get(i));
        }

        sb.append("\n");
        ANSWER.add(sb.toString());
    }

    private static int calTotalValue(List<Integer> numbers, List<String> signs) {
        // 공백제거
        StringBuilder sb = new StringBuilder();
        sb.append(numbers.get(0));
        for (int i=1; i<numbers.size(); i++) {
            String sign = signs.get(i-1);
            if (sign.equals(" ")) {
                sb.append(numbers.get(i));
            } else {
                sb.append(sign).append(numbers.get(i));
            }
        }

        // 계산
        String noSpaceExpression = sb.toString();

        StringTokenizer st = new StringTokenizer(noSpaceExpression, "+-", true);
        int result = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            int nextNum = Integer.parseInt(st.nextToken());

            if (op.equals("+")) {
                result += nextNum;
            } else {
                result -= nextNum;
            }
        }

        return result;
    }

    private static void printAnswer() {
        ANSWER.sort(Comparator.naturalOrder());
        for (String str : ANSWER) {
            System.out.print(str);
        }
        System.out.println();
    }
}