package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_1213 {

    static String BAD_STR = "I'm Sorry Hansoo";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        List<String> processor = new ArrayList<>();

        for (int i=0; i<input.length; i++) {
            processor.add(input[i]);
        }
        processor.sort(Comparator.naturalOrder());
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        int index = 0;
        int nowSize = processor.size();
        int changeCount = 0;
        boolean flag = false;
        while (processor.size() > 1) {
            if (changeCount == nowSize) {
                flag = true;
                break;
            }
            String now = processor.get(index);
            String next = processor.get(index+1);
            if (now.equals(next)) {
                start.append(now);
                end.append(next);
                processor.remove(0);
                processor.remove(0);
                changeCount = 0;
                nowSize = processor.size();
            } else {
                String remove = processor.remove(0);
                processor.add(remove);
                changeCount++;
            }
        }
        if (flag) {
            System.out.println(BAD_STR);
        } else {
            if (!processor.isEmpty()) {
                start.append(processor.get(0));
            }

            end.reverse();
            System.out.println(start.toString() + end.toString());
        }
    }

}
