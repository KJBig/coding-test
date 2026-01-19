package backjoon.twenty_six.jan;

import java.util.*;

public class PG17684 {

    class Solution {

        static int WORD_INDEX_SIZE;
        static Map<String, Integer> WORD_INDEX = new HashMap<>();

        public int[] solution(String msg) {
            int[] answer = {};
            List<Integer> indexes = new ArrayList<>();

            // init index
            for (int i=0; i<26; i++) {
                int index = 65+i;
                WORD_INDEX.put(String.valueOf((char) index), i+1);
            }
            WORD_INDEX_SIZE = 26;

            // process start
            for (int i=0; i<msg.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(msg.charAt(i)));

                // get test word
                int checkSize = 0;
                while (WORD_INDEX.containsKey(sb.toString())) {
                    checkSize++;
                    if (i+checkSize >= msg.length()) {
                        break;
                    }
                    sb.append(String.valueOf(msg.charAt(i+checkSize)));
                }


                // get index && put index
                int wordIndex = 0;

                if (!WORD_INDEX.containsKey(sb.toString())) {
                    WORD_INDEX_SIZE++;
                    WORD_INDEX.put(sb.toString(), WORD_INDEX_SIZE);
                    sb.delete(sb.length()-1, sb.length());

                    wordIndex = WORD_INDEX.get(sb.toString());
                } else {
                    wordIndex = WORD_INDEX.get(sb.toString());
                }

                indexes.add(wordIndex);
                i += checkSize-1;
            }


            // build answer
            answer = new int[indexes.size()];

            for (int i=0; i<answer.length; i++) {
                answer[i] = indexes.get(i);
            }

            return answer;
        }
    }

}
