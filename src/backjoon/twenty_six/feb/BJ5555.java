package backjoon.twenty_six.feb;

import java.io.*;

public class BJ5555 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=0; i<n; i++) {
            String ring = br.readLine();
            String circularRing = ring + ring;

            if (circularRing.contains(target)) {
                count++;
            }
        }

        System.out.println(count);

    }
}
