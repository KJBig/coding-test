package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1284 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            int answer = 1;
            String[] split = input.split("");
            for (String s : split) {
                if (s.equals("0")) {
                    answer+=4;
                } else if (s.equals("1")) {
                    answer+=2;
                } else {
                    answer+=3;
                }
                answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

}
