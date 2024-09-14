package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_11723 {
    static Set<Integer> LIST = new HashSet<>();
    static StringBuilder SB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("add")) {
                add(split);
            }

            if (split[0].equals("remove")) {
                remove(split);
            }

            if (split[0].equals("check")) {
                SB.append(check(split)).append("\n");
            }

            if (split[0].equals("toggle")) {
                if (check(split) == 0){
                    add(split);
                }else {
                    remove(split);
                }
            }

            if (split[0].equals("all")) {
                all();
            }

            if (split[0].equals("empty")) {
                LIST.clear();
            }

        }
        System.out.println(SB.toString());

    }

    private static void all() {
        LIST.clear();
        for (int i=1; i<=20; i++) {
            LIST.add(i);
        }
    }

    private static int check(String[] split) {
        int answer = 0;
        if(LIST.contains(Integer.parseInt(split[1]))){
            answer = 1;
        }
        return answer;
    }

    private static void remove(String[] split) {
        int number = Integer.parseInt(split[1]);
        LIST.remove(number);
    }

    private static void add(String[] split) {
        LIST.add(Integer.parseInt(split[1]));
    }
}
