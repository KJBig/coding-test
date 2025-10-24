package backjoon.twenty_five.oct;

import java.util.*;


public class PG64065 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            s = s.replace("}}", "}");
            s = s.replace("{{", "{");
            String[] tuples = s.split("},");

            Arrays.sort(tuples, Comparator.comparingInt(String::length));
            List<String> items = new ArrayList<>();

            for (int i=0; i<tuples.length; i++) {
                String target = tuples[i].replace("{", "").replace("}", "");
                for (String item: target.split(",")) {
                    if (!items.contains(item)) {
                        items.add(item);
                    }
                }
            }

            answer = items.stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();

            return answer;
        }
    }
}
