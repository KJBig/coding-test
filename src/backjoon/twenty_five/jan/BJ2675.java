package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            int repeat = Integer.parseInt(split[0]);
            String[] str = split[1].split("");
            for (String s : str) {
                for (int j=0; j<repeat; j++) {
                    sb.append(s);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
