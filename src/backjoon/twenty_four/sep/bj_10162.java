package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] button = new int[]{300, 60, 10};
        int[] result = new int[3];

        int index = 0;

        while (true) {
            if (T == 0) {
                printResult(result);
                break;
            }

            if (T<button[2] || index >= 3) {
                System.out.println(-1);
                break;
            }

            if (T >= button[index]) {
                T -= button[index];
                result[index]++;
            } else {
                index++;
            }
        }
    }

    private static void printResult(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
