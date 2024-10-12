package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] order = br.readLine().split(" ");
            String[] numbers = br.readLine().split(" ");
            Queue<Docs> queue = new LinkedList<>();
            int maxOrder = Integer.parseInt(numbers[0]);


            int N = Integer.parseInt(order[0]);
            int target = Integer.parseInt(order[1]);

            for (int k=0; k<N; k++) {
                boolean isTarget = false;
                if (k == target) {
                    isTarget = true;
                }
                int numberOrder = Integer.parseInt(numbers[k]);
                queue.add(new Docs(isTarget, numberOrder));
                maxOrder = Math.max(maxOrder, numberOrder);
            }

            int count = 0;
            while (true) {
                Docs poll = queue.poll();
                if (poll.getOrder() == maxOrder) {
                    count++;
                    if (poll.getIsTarget()) {
                        break;
                    }

                    if (!queue.isEmpty()) {
                        maxOrder = getMaxOrder(queue);
                    } else {
                        break;
                    }

                } else {
                    queue.add(poll);
                }
            }
            System.out.println(count);
        }


    }

    private static int getMaxOrder(Queue<Docs> queue) {
        int MAX_ORDER = Integer.MIN_VALUE;
        for (Docs doc : queue) {
            MAX_ORDER = Math.max(MAX_ORDER, doc.getOrder());
        }
        return MAX_ORDER;
    }

    static class Docs {
        private boolean isTarget;
        private int order;

        public Docs(boolean isTarget, int order) {
            this.isTarget = isTarget;
            this.order = order;
        }

        public boolean getIsTarget() {
            return isTarget;
        }

        public int getOrder() {
            return order;
        }
    }

}
