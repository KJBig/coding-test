package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int nowIndex = 0;
        int count = 0;
        for (int i=0; i<N; i++) {
            if (Integer.parseInt(numbers[i]) == nowIndex) {
                count++;
                nowIndex++;
                if (nowIndex > 2 ) {
                    nowIndex = 0;
                }
            }
        }

        System.out.println(count);
    }
}
