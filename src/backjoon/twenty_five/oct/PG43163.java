package backjoon.twenty_five.oct;

import java.util.*;


public class PG43163 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            int[] visited = new int[words.length];
            int targetIndex = -1;

            for (int i=0; i<words.length; i++) {
                if (words[i].equals(target)) {
                    targetIndex = i;
                    break;
                }
            }

            if (targetIndex == -1) {
                return 0;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(begin, 0));

            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                for (int i=0; i<words.length; i++) {
                    String word = words[i];
                    if (canConvert(poll.word, word)) {
                        if (visited[i] == 0) {
                            visited[i] = poll.count+1;
                            queue.add(new Node(word, poll.count+1));
                        } else {
                            if (visited[i] > (poll.count+1) ) {
                                visited[i] = poll.count+1;
                                queue.add(new Node(word, poll.count+1));
                            }
                        }
                    }
                }

            }

            answer = visited[targetIndex];
            return answer;
        }

        class Node {
            String word;
            int count;

            public Node(String word, int count) {
                this.word = word;
                this.count = count;
            }
        }

        private boolean canConvert(String word, String targetWord) {
            int matchCount = 0;
            for (int i=0; i<word.length(); i++) {
                if (word.charAt(i) == targetWord.charAt(i)) {
                    matchCount++;
                }
            }
            return matchCount == (word.length()-1);
        }
    }
}
