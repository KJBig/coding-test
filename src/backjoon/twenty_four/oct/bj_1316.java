package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i=0; i<N; i++) {
            String before = "";
            boolean endFlag = false;
            List<String> history = new ArrayList<>();
            String[] word = br.readLine().split("");
            for (String alpha : word) {
                if (!alpha.equals(before)) {
                    if (history.contains(alpha)) {
                        endFlag = true;
                        break;
                    }
                    history.add(alpha);
                    before = alpha;
                }
            }

            if (!endFlag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
