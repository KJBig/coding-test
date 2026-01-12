package backjoon.twenty_six.jan;

import java.io.*;

public class BJ20310 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().trim().toCharArray();
        int n = str.length;

        int zeroCount = 0;
        int oneCount = 0;

        for (char c : str) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        int zeroRemoveCount = zeroCount / 2;
        int oneRemoveCount = oneCount / 2;

        boolean[] removed = new boolean[n];

        // 1 제거
        for (int i=0; i<n; i++) {
            if (oneRemoveCount <= 0) {
                break;
            }

            if (str[i] == '1') {
                removed[i] = true;
                oneRemoveCount--;
            }
        }

        // 0 제거
        for (int i=n-1; i>=0; i--) {
            if (zeroRemoveCount <= 0) {
                break;
            }

            if (!removed[i] && str[i] == '0') {
                removed[i] = true;
                zeroRemoveCount--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (!removed[i]) {
                sb.append(str[i]);
            }
        }

        System.out.print(sb.toString());
    }
}

