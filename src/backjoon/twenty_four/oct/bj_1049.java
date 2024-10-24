package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int packMin = Integer.MAX_VALUE;
        int eachMin = Integer.MAX_VALUE;

        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            packMin = Math.min(packMin, Integer.parseInt(input[0]));
            eachMin = Math.min(eachMin, Integer.parseInt(input[1]));
        }

        if (packMin > eachMin*6) {
            packMin = eachMin*6;
        }

        int packNum = N/6;
        int packRest = N%6;
        int answer = 0;

        answer += (packNum*packMin);

        if (packRest*eachMin < packMin) {
            answer += packRest*eachMin;
        } else {
          answer += packMin;
        }
        System.out.println(answer);
    }

}
