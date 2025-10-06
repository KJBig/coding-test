package backjoon.twenty_five.oct;
import java.util.*;

public class PG42583 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int time = 0;
            int nowBridgeWeight = 0;

            for (int i = 0; i < bridge_length; i++) {
                bridge.add(0);
            }

            int index = 0;
            while (index < truck_weights.length) {
                time++;

                nowBridgeWeight -= bridge.poll();

                int next = truck_weights[index];
                if (nowBridgeWeight + next <= weight) {
                    bridge.add(next);
                    nowBridgeWeight += next;
                    index++;
                } else {
                    bridge.add(0);
                }
            }

            return time + bridge_length;
        }
    }

}
