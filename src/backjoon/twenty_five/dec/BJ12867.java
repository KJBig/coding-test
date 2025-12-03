package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ12867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<HashMap<Integer, Integer>> history = new ArrayList<>();

        int M = Integer.parseInt(br.readLine());
        StringTokenizer indexInput = new StringTokenizer(br.readLine());

        int[] indexes = new int[M];
        String[] actions = br.readLine().split("");
        boolean isPossible = true;

        for (int i=0; i<M; i++) {
            indexes[i] = Integer.parseInt(indexInput.nextToken());
        }
        HashMap<Integer, Integer> initLocation = new HashMap<>();
        initLocation.put(1, 0);
        history.add(initLocation);

        for (int i=0; i<M; i++) {
            HashMap<Integer, Integer> nowLocation = getLocation(history);

            //  add index
            int nowIndex = indexes[i];
            if (!nowLocation.containsKey(nowIndex)) {
                nowLocation.put(nowIndex, 0);
            }

            // move
            String nowAction = actions[i];
            if (nowAction.equals("+")) {
                nowLocation.put(nowIndex, nowLocation.get(nowIndex) + 1);
            } else if (nowAction.equals("-")) {
                nowLocation.put(nowIndex, nowLocation.get(nowIndex) - 1);
            }

            if (!checkPossible(history, nowLocation)) {
                isPossible = false;
                break;
            }

            history.add(nowLocation);
        }

        System.out.println(isPossible ? 1 : 0);
    }

    private static boolean checkPossible(List<HashMap<Integer, Integer>> history, HashMap<Integer, Integer> nowLocation) {
        if (history.isEmpty()) {
            return true;
        }

        for (HashMap<Integer, Integer> preLocation : history) {
            boolean sameFlag = true;

            for (Integer key : nowLocation.keySet()) {
                if (!preLocation.containsKey(key)) {
                    if (nowLocation.get(key) == 0) {
                        continue;
                    }
                    sameFlag = false;
                    break;
                }
                if (preLocation.get(key) != nowLocation.get(key)) {
                    sameFlag = false;
                    break;
                }
            }

            if (sameFlag) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<Integer, Integer> getLocation(List<HashMap<Integer, Integer>> history) {
        HashMap<Integer, Integer> nowLocation = new HashMap<>();
        if (history.isEmpty()) {
            return nowLocation;
        }

        HashMap<Integer, Integer> preLocation = history.get(history.size() - 1);

        for (Integer key : preLocation.keySet()) {
            nowLocation.put(key, preLocation.get(key));
        }

        return nowLocation;
    }
}
