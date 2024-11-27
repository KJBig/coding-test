package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");
        String[] target = br.readLine().split("");
        int answer = 0;

        for (int i=0; i<=str.length - target.length; i++) {
            boolean flag = false;
            if (str[i].equals(target[0])) {
                if (target.length == 1) {
                    flag = true;
                }
                for (int j = 1; j < target.length; j++) {
                    if (!str[i+j].equals(target[j])) {
                        flag = false;
                        break;
                    }

                    if (str[i+j].equals(target[target.length-1])) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                answer++;
                i += (target.length-1);
            }
        }

        System.out.println(answer);

    }
}
