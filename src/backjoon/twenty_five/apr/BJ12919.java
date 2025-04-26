package backjoon.twenty_five.apr;

import java.io.*;

public class BJ12919 {
    static int answer = 0;
    static String startStr, targetStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        startStr = br.readLine();
        targetStr = br.readLine();

        dfs(targetStr);

        System.out.println(answer);
    }

    private static void dfs(String current) {
        if (current.length() < startStr.length()) {
            return;
        }

        if (current.equals(startStr)) {
            answer = 1;
            return;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            dfs(current.substring(0, current.length() - 1));
        }

        if (current.charAt(0) == 'B') {
            String reversed = new StringBuilder(current.substring(1)).reverse().toString();
            dfs(reversed);
        }
    }
}
