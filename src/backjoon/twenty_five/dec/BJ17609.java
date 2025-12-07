package backjoon.twenty_five.dec;

import java.io.*;

public class BJ17609 {
    static int ANSWER = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String str = br.readLine();
            ANSWER = 2;
            checkString(str, 0, str.length()-1, false);
            System.out.println(ANSWER);
        }
    }

    private static void checkString(String str, int start, int end, boolean chance) {
        if (start>=end) {
            if (chance) {
                ANSWER = 1;
            } else {
                ANSWER = 0;
            }
            return;
        }

        if (str.charAt(start) != str.charAt(end)) {
            if (!chance) {
                checkString(str, start + 1, end, true);
                checkString(str, start, end - 1, true);
            }
        } else {
            checkString(str, start + 1, end - 1, chance);
        }

    }
}
