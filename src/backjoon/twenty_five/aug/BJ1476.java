package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ1476 {
    static ArrayList<Long> LIST;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LIST = new ArrayList<>();

        if(n <= 10) {
            System.out.println(n);
        } else if(n > 1022) {
            System.out.println(-1);
        } else {
            for(int i = 0; i < 10; i++) {
                process(i, 1);
            }
            Collections.sort(LIST);

            System.out.println(LIST.get(n));
        }


    }

    public static void process(long num, int idx) {
        if(idx > 10) return;

        LIST.add(num);
        for(int i = 0; i < num % 10; i++) {
            process((num * 10) + i, idx + 1);
        }
    }

}
