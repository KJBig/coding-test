package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String me = br.readLine();
        String doctor = br.readLine();

        if (me.length() >= doctor.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }

    }
}
