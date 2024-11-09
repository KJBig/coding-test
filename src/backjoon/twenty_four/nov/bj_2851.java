package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int[] shu = new int[10];

        for (int i=0; i<10; i++) {
            shu[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        while (true) {
            if (index == 10) {
                break;
            }
            if ((answer + shu[index]) > 100 ) {
                break;
            }
            answer += shu[index];
            index++;
        }

        if (answer < 100 && index < 10) {
            int before = Math.abs(answer-100);
            int after = Math.abs(answer+shu[index]-100);

            if (after < before) {
                answer += shu[index];
            } else if (after == before) {
                answer += shu[index];
            }
        }

        System.out.println(answer);
    }
}
