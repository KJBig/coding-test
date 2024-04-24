package backjoon.twenty_four.apr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class bj_11651 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int start = 0;
        int end = N-1;
        int sum = numbers[start] +  numbers[end];
        int count = 0;

        while (start<end) {
            if (sum > X) {
                sum -= numbers[end];
                end--;
                sum += numbers[end];
            } else if (sum < X){
                sum -= numbers[start];
                start++;
                sum += numbers[start];
            } else {
                count++;
                sum -= numbers[start];
                start++;
                sum += numbers[start];
            }
        }

        System.out.println(count);

    }
}