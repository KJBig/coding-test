package backjoon.twenty_six.feb;

import java.util.*;

public class PG17677 {
    class Solution {
        public int solution(String str1, String str2) {
            String upperStr1 = str1.toUpperCase();
            String upperStr2 = str2.toUpperCase();

            List<String> elements1 = getElements(upperStr1);
            List<String> elements2 = getElements(upperStr2);

            Map<String, Integer> map1 = toCountMap(elements1);
            Map<String, Integer> map2 = toCountMap(elements2);

            int intersectionSize = getIntersectionSize(map1, map2);
            int unionSize = getUnionSize(map1, map2);


            if (unionSize == 0) {
                return 65536;
            }

            double jaccard = (double) intersectionSize / unionSize;
            return (int) (jaccard * 65536);
        }

        private List<String> getElements(String word) {
            List<String> elements = new ArrayList<>();

            for (int i=0; i<word.length()-1; i++) {
                char a = word.charAt(i);
                char b = word.charAt(i+1);

                if (!isUpperAlpha(a) || !isUpperAlpha(b)) {
                    continue;
                }

                elements.add("" + a + b);
            }

            return elements;
        }

        private boolean isUpperAlpha(char c) {
            return c >= 'A' && c <= 'Z';
        }

        private Map<String, Integer> toCountMap(List<String> elements) {
            Map<String, Integer> map = new HashMap<>();
            for (String key : elements) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            return map;
        }

        private int getIntersectionSize(Map<String, Integer> map1, Map<String, Integer> map2) {
            int sum = 0;
            for (String key : map1.keySet()) {
                if (map2.containsKey(key)) {
                    sum += Math.min(map1.get(key), map2.get(key));
                }
            }
            return sum;
        }

        private int getUnionSize(Map<String, Integer> map1, Map<String, Integer> map2) {
            int sum = 0;

            for (String key : map1.keySet()) {
                int c1 = map1.get(key);
                int c2 = map2.getOrDefault(key, 0);
                sum += Math.max(c1, c2);
            }

            for (String key : map2.keySet()) {
                if (!map1.containsKey(key)) {
                    sum += map2.get(key);
                }
            }

            return sum;
        }
    }

}
