package backjoon.twenty_four.oct;

import java.io.*;

public class bj_1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now = 64;
        int answer = 1;

        while (now != 0) {
            if (now == N) {
                System.out.println(answer);
                break;
            } else if (now > N) {
                now /= 2;
            } else {
                N-=now;
                answer++;
                now /= 2;
            }
        }

    }

}
