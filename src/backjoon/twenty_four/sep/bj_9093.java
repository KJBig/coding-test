package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class bj_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j=0; j<str.length; j++) {
                String[] word = str[j].split("");
                List<String> words = Stream.of(word).collect(Collectors.toList());
                Collections.reverse(words);
                for (int k=0; k<words.size(); k++) {
                    sb.append(words.get(k));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
