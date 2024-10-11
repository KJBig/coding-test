package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int now = 1;
        int mo = 1;
        int ja = 1;
        boolean flag = false;

        for (int i=1; i<N; i++) {
            if (!flag) {
                if (mo == now) {
                    now++;
                    mo = now;
                    flag = true;
                } else {
                    ja--;
                    mo++;
                }
            } else {
                if (ja == now) {
                    now++;
                    ja = now;
                    flag = false;
                } else {
                    ja++;
                    mo--;
                }
            }

        }
        System.out.println(ja + "/" + mo);
    }
}
