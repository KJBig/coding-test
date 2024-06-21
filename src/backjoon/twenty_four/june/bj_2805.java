package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class bj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] numberInput = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }

        int start = 0;
        int end = Arrays.stream(numbers).max().getAsInt();
        int mid = (start+end)/2;
        long treeNum = getTreeNum(mid, numbers);

        while (start <= end) {
            if (treeNum < M) {
                end = mid - 1;
            } else {
                start = mid+1;
            }
            mid = (start+end)/2;
            treeNum = getTreeNum(mid, numbers);
        }
        System.out.println(mid);
    }

    private static long getTreeNum(int size, int[] numbers) {
        long result = 0;
        for (int number : numbers) {
            if (number > size) {
                result += number-size;
            }
        }
        return result;
    }
}
