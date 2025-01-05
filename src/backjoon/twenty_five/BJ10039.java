package backjoon.twenty_five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] students = new int[5];
        for (int i=0; i<5; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for (int i=0; i<5; i++) {
            if (students[i]<40) {
                answer += 40;
            } else {
                answer += students[i];
            }
        }

        System.out.println(answer/5);

    }
}
