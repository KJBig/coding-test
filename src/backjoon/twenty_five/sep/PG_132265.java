package backjoon.twenty_five.sep;

import java.util.*;

class PG_132265 {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<String, Integer> leftMap = new HashMap<>();
        HashMap<String, Integer> rightMap = new HashMap<>();

        // 초기 설정
        for (int i=0; i<topping.length; i++) {
            putToppingNumberToStrKey(rightMap, topping[i]);
        }

        // Process
        for (int i=0; i<topping.length; i++) {
            if (leftMap.keySet().size() == rightMap.keySet().size()) {
                answer++;
            }

            putToppingNumberToStrKey(leftMap, topping[i]);
            removeByToppingnumber(rightMap, topping[i]);
        }

        return answer;
    }

    private void putToppingNumberToStrKey(HashMap<String, Integer> hashMap, int toppingNumber) {
        String strKey = String.valueOf(toppingNumber);
        if (!hashMap.containsKey(strKey)) {
            hashMap.put(strKey, 0);
        }
        hashMap.put(strKey, hashMap.get(strKey)+1);
    }

    private void removeByToppingnumber(HashMap<String, Integer> hashMap, int toppingNumber) {
        String strKey = String.valueOf(toppingNumber);
        if (hashMap.get(strKey) == 1) {
            hashMap.remove(strKey);
        } else {
            hashMap.put(strKey, hashMap.get(strKey)-1);
        }
    }

}