package backjoon.twenty_five.oct;

import java.util.*;

public class PG86971 {
    class Solution {
        static boolean[] visited;
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            List<List<Integer>> edges = new ArrayList<>();

            for (int i=0; i<n; i++){
                edges.add(new ArrayList<>());
            }

            for (int i=0; i<wires.length; i++){
                int[] now = wires[i];
                edges.get(now[0]-1).add(now[1]-1);
                edges.get(now[1]-1).add(now[0]-1);
            }

            for (int i=0; i<wires.length; i++) {
                visited = new boolean[edges.size()];
                List<Integer> sizes = new ArrayList<>();
                for (int j=0; j<n; j++) {
                    if (!visited[j]) {
                        int size = search(edges, j, wires[i]);
                        sizes.add(size);
                    }
                }

                int absSub = getAbsSub(sizes);
                answer = Math.min(answer, absSub);
            }

            return answer;
        }

        private int search(List<List<Integer>> edges, int start, int[] removeEdge) {
            Queue<Integer> queue = new LinkedList<>();

            queue.add(start);
            visited[start] = true;
            int count = 1;

            while (!queue.isEmpty()) {
                int poll = queue.poll();
                List<Integer> adj = edges.get(poll);

                for (int i=0; i<adj.size(); i++) {
                    int nowEdge = adj.get(i);
                    if ((poll+1==removeEdge[0] && nowEdge+1==removeEdge[1])
                            || (poll+1==removeEdge[1] && nowEdge+1==removeEdge[0])) {
                        continue;
                    }
                    if (!visited[nowEdge]) {
                        count++;
                        visited[nowEdge] = true;
                        queue.add(nowEdge);
                    }
                }
            }

            return count;

        }

        private int getAbsSub(List<Integer> sizes) {
            int sub = sizes.get(0);
            for (int i=1; i<sizes.size(); i++) {
                sub -= sizes.get(i);
            }
            return Math.abs(sub);
        }


    }
}
