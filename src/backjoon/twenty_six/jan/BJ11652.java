package backjoon.twenty_six.jan;

import java.io.*;
import java.util.Arrays;

public class BJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] numbers = new long[N];

        for (int i=0; i<N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(numbers);

        long maxCount = 0;
        long maxValue = 0;

        long nowValue = 0;
        long nowCount = 0;


        maxValue = numbers[0];
        maxCount++;

        nowValue = numbers[0];
        nowCount++;

        for (int i=1; i<N; i++) {
            if (numbers[i] == nowValue) {
                nowCount++;
            } else {
                if (maxCount < nowCount) {
                    maxCount = nowCount;
                    maxValue = nowValue;
                }
                nowValue = numbers[i];
                nowCount = 1;
            }
        }

        if (maxCount < nowCount) {
            maxCount = nowCount;
            maxValue = nowValue;
        }


        System.out.println(maxValue);
    }
}
