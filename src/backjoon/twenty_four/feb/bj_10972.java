package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10972 {
    private static int[] NUMBERS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        NUMBERS = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (nextPermutation()) {
            for (int i = 0; i < N; i++) {
                System.out.print(NUMBERS[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    private static boolean nextPermutation() {
        int i = NUMBERS.length - 1;
        while (i > 0 && NUMBERS[i - 1] >= NUMBERS[i]) i--;
        if (i <= 0) return false;

        int j = NUMBERS.length - 1;
        while (NUMBERS[j] <= NUMBERS[i - 1]) j--;

        swap(i - 1, j);
        reversNums(i);
        return true;
    }

    private static void swap(int index1, int index2) {
        int temp = NUMBERS[index1];
        NUMBERS[index1] = NUMBERS[index2];
        NUMBERS[index2] = temp;
    }

    private static void reversNums(int i) {
        int j;
        j = NUMBERS.length - 1;
        while (i < j) {
            swap(i, j);
            i++; j--;
        }
    }
}
