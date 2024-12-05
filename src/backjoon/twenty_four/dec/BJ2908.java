package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        StringBuffer sba = new StringBuffer(split[0]);
        StringBuffer sbb = new StringBuffer(split[1]);
        int a = Integer.parseInt(sba.reverse().toString());
        int b = Integer.parseInt(sbb.reverse().toString());

        System.out.println(Math.max(a, b));

    }
}
