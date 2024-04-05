package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for (int i=0; i<split.length; i++){
            String str = split[i];
            if (str.equals(".")) {
                if (size != 0) {
                    if (size%2 != 0) {
                        sb = new StringBuilder("-1");
                        break;
                    }
                    sb.append(getStr(size));
                    size = 0;
                }
                sb.append(".");
            } else {
                size++;
            }
        }

        if (size%2 != 0) {
            sb = new StringBuilder("-1");
        } else {
            sb.append(getStr(size));
        }

        String result = sb.toString();

        System.out.println(result);
    }

    private static String getStr(int size) {
        StringBuilder sb = new StringBuilder();
        if (size % 2 != 0){
            sb = new StringBuilder("-1");
        } else if (size % 4 == 0){
            sb.append("AAAA".repeat(size / 4));
        } else {
            sb.append("AAAA".repeat(size / 4));
            sb.append("BB");
        }
        return sb.toString();
    }
}
