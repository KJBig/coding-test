package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int X = Integer.parseInt(split[1]);

        String[] numbers = br.readLine().split(" ");

        int start = 0;
        int end = start+X-1;

        int maxTotal = 0;
        int nowTotal = getTotal(numbers, start, end);
        int count = 0;
        while (true) {
            if (maxTotal < nowTotal) {
                count = 1;
                maxTotal = nowTotal;
            } else if (maxTotal == nowTotal) {
                count++;
            }
            start++;
            end++;
            if (end >= N) {
                break;
            }
            nowTotal-=Integer.parseInt(numbers[start-1]);
            nowTotal+=Integer.parseInt(numbers[end]);


        }
        if (maxTotal != 0) {
            System.out.println(maxTotal);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }

    private static int getTotal(String[] numbers, int start, int end) {
        int sum = 0;
        for (int i=start; i<=end; i++) {
            sum+= Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
