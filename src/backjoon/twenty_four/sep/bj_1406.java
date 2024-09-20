package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class bj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initWord = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(initWord);
        int loc = initWord.length();
        for (int i=0; i<N; i++) {
            String[] order = br.readLine().split(" ");
            switch (order[0]){
                case "L": if(loc>0) loc--; break;
                case "D": if(loc<sb.length()) loc++; break;
                case "B": if(loc>0) {sb.deleteCharAt(loc-1); loc--;} break;
                case "P": sb.insert(loc, order[1]); loc++; break;
            }
        }
        System.out.println(sb);
    }
}
