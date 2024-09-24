package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> elements = new ArrayList<>();
        String input = br.readLine();
        int totalLen = input.length();

        for (int i=0; i<totalLen; i++) {
            elements.add(input.substring(i, totalLen));
        }

        elements.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element).append(" ");
        }
        System.out.println(sb);
    }
}
