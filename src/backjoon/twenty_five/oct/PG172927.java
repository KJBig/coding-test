package backjoon.twenty_five.oct;

import java.util.*;


public class PG172927 {
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.level).reversed());
            int pickCount = 0;
            for (int pick : picks) {
                pickCount += pick;
            }

            int mineralSize = pickCount*5;
            if (minerals.length < mineralSize) {
                mineralSize = minerals.length;
            }

            Node nowNode = new Node();
            for(int i=1; i<=mineralSize; i++) {
                String nowMineral = minerals[i-1];
                nowNode.level += addEnergy(nowMineral, "stone");
                nowNode.minerals.add(nowMineral);

                if (i%5 == 0 || i==mineralSize) {
                    queue.add(nowNode);
                    nowNode = new Node();
                }
            }

            // 곡괭이 할당
            HashMap<String, Integer> pickTypes = new HashMap<>();
            pickTypes.put("diamond", picks[0]);
            pickTypes.put("iron", picks[1]);
            pickTypes.put("stone", picks[2]);

            for (String pickType : pickTypes.keySet()) {
                for (int i=0; i<pickTypes.get(pickType); i++) {
                    if(queue.isEmpty()){
                        break;
                    }

                    Node pollNode = queue.poll();
                    for (String mineral : pollNode.minerals) {
                        answer += addEnergy(mineral, pickType);
                    }
                }
            }

            return answer;
        }

        private int addEnergy(String mineralType, String pickType) {
            int energy = 0;
            int diamondEnergy = getDiamondEnergy(pickType);
            int ironEnergy = getIronEnergy(pickType);
            int stoneEnergy = getStoneEnergy(pickType);

            if (mineralType.equals("diamond")) {
                energy += diamondEnergy;
            } else if (mineralType.equals("iron")) {
                energy += ironEnergy;
            } else if (mineralType.equals("stone")) {
                energy += stoneEnergy;
            }

            return energy;
        }

        private int getDiamondEnergy(String pickType) {
            int energy = 0;
            if (pickType.equals("diamond")) {
                energy = 1;
            } else if (pickType.equals("iron")) {
                energy = 5;
            } else if (pickType.equals("stone")) {
                energy = 25;
            }
            return energy;
        }

        private int getIronEnergy(String pickType) {
            int energy = 0;
            if (pickType.equals("diamond")) {
                energy = 1;
            } else if (pickType.equals("iron")) {
                energy = 1;
            } else if (pickType.equals("stone")) {
                energy = 5;
            }
            return energy;
        }

        private int getStoneEnergy(String pickType) {
            int energy = 0;
            if (pickType.equals("diamond")) {
                energy = 1;
            } else if (pickType.equals("iron")) {
                energy = 1;
            } else if (pickType.equals("stone")) {
                energy = 1;
            }
            return energy;
        }

        class Node {
            public int level;
            public List<String> minerals;

            public Node() {
                this.level = 0;
                this.minerals = new ArrayList<>();
            }
        }
    }
}
