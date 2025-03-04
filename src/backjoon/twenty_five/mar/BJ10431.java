package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            int[] numbers = new int[20];
            int index = Integer.parseInt(split[0]);
            int count = 0;

            for (int j=0; j<20; j++) {
                numbers[j] = Integer.parseInt(split[j+1]);
            }

            for (int j=0; j<20; j++) {
                int now = numbers[j];
                for (int k=0; k<j; k++) {
                    if (now < numbers[k]) {
                        for (int l=j; l>k; l--) {
                            numbers[l] = numbers[l-1];
                            count++;
                        }
                        numbers[k] = now;
                        break;
                    }
                }

            }

            sb.append(index).append(" ").append(count).append("\n");

        }
        System.out.println(sb);
    }
}
