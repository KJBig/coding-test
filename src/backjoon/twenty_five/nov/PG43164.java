package backjoon.twenty_five.nov;

import java.util.*;


public class PG43164 {
    class Solution {
        static boolean[] VISITED;
        static List<String> RESULT = new ArrayList<>();
        static boolean FLAG = false;
        public String[] solution(String[][] tickets) {
            String[] answer = {};
            HashMap<String, List<Node>> map = new HashMap<>();
            VISITED = new boolean[tickets.length];

            for (int i=0; i<tickets.length; i++) {
                String[] now = tickets[i];
                if (!map.containsKey(now[0])) {
                    map.put(now[0], new ArrayList<>());
                }
                map.get(now[0]).add(new Node(i, now[0], now[1]));
            }

            for (String key : map.keySet()) {
                map.get(key).sort(Comparator.comparing(n -> n.end));
            }

            List<String> temp = new ArrayList<>();
            temp.add("ICN");
            dfs(map, 0, "ICN", temp, tickets.length);


            answer = new String[RESULT.size()];

            for (int i=0; i<RESULT.size(); i++) {
                answer[i] = RESULT.get(i);
            }

            return answer;
        }

        private void dfs(HashMap<String, List<Node>> map, int count, String target, List<String> result, int totalSize) {
            if (count == totalSize) {
                for (int i=0; i<result.size(); i++) {
                    RESULT.add(result.get(i));
                }
                FLAG = true;
                return;
            }

            if (!map.containsKey(target)) {
                return;
            }

            for (Node node : map.get(target)) {
                if (FLAG) {
                    break;
                }
                if (!VISITED[node.id]) {
                    result.add(node.end);
                    VISITED[node.id] = true;
                    dfs(map, count+1, node.end, result, totalSize);
                    result.remove(result.size()-1);
                    VISITED[node.id] = false;
                }

            }

        }

        class Node {
            int id;
            String start;
            String end;

            public Node(int id, String start, String end) {
                this.id = id;
                this.start = start;
                this.end = end;
            }
        }
    }
}
