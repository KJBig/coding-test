package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ10282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int test_case=0; test_case<T; test_case++) {
            String[] initInput = br.readLine().split(" ");
            int n = Integer.parseInt(initInput[0]);
            int d = Integer.parseInt(initInput[1]);
            int c = Integer.parseInt(initInput[2]);

            List<List<NodeData>> nodeDatas = new ArrayList<>();
            boolean[] isHacking = new boolean[n + 1];
            int[] hackingTime = new int[n + 1];

            for (int i=0; i<=n; i++) {
                nodeDatas.add(new ArrayList<>());
            }

            Arrays.fill(hackingTime, -1);

            for (int i = 0; i < d; i++) {
                String[] nodeInput = br.readLine().split(" ");
                int a = Integer.parseInt(nodeInput[0]);
                int b = Integer.parseInt(nodeInput[1]);
                int s = Integer.parseInt(nodeInput[2]);

                nodeDatas.get(b).add(new NodeData(a, s));
            }


            Queue<Integer> queue = new LinkedList<>();
            queue.add(c);
            isHacking[c] = true;
            hackingTime[c] = 0;

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                List<NodeData> nextNodes = nodeDatas.get(poll);


                for (NodeData nextNode : nextNodes) {
                    if (!isHacking[nextNode.index]) {
                        isHacking[nextNode.index] = true;
                        hackingTime[nextNode.index] = hackingTime[poll] + nextNode.time;
                        queue.add(nextNode.index);
                    } else if (hackingTime[nextNode.index] > hackingTime[poll] + nextNode.time) {
                        hackingTime[nextNode.index] = hackingTime[poll] + nextNode.time;
                        queue.add(nextNode.index);
                    }
                }
            }

            int hackingCount = 0;
            int maxTime = 0;

            for (int i=1; i<=n; i++) {
                 if (hackingTime[i] != -1) {
                     hackingCount++;
                     maxTime = Math.max(maxTime, hackingTime[i]);
                 }
            }

            sb.append(hackingCount).append(" ").append(maxTime).append("\n");
        }

        System.out.println(sb);

    }

    static class NodeData {

        int index;
        int time;

        public NodeData(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
