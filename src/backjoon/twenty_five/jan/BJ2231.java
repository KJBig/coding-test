package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;

        for (int i=N-1; i>0; i--) {
            boolean isPossible = getPossibleStatus(N, i);
            if (isPossible) {
                answer = Math.min(answer, i);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        System.out.println(answer);

    }

    private static boolean getPossibleStatus(int N, int i) {
        String[] split = String.valueOf(i).split("");
        int answer = i;
        for (String s : split) {
            answer += Integer.parseInt(s);
        }
        return answer == N;
    }

}
