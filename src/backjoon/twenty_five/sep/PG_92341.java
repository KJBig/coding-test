package backjoon.twenty_five.sep;

import java.util.*;

public class PG_92341 {

    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            HashMap<String, String> logs = new HashMap<>();
            HashMap<Integer, Integer> result = new HashMap<>();

            for (String record : records) {
                String[] data = record.split(" ");
                String time = data[0];
                String carNumber = data[1];
                String action = data[2];

                if (action.equals("IN")) {
                    logs.put(carNumber, time);
                }

                if (action.equals("OUT")) {
                    String inTime = logs.get(carNumber);
                    int subTime = convertTimeToMinute(time) - convertTimeToMinute(inTime);
                    addTime(result, carNumber, subTime);
                    logs.remove(carNumber);
                }
            }

            for (String carNumber : logs.keySet()) {
                String inTime = logs.get(carNumber);
                int subTime = convertTimeToMinute("23:59") - convertTimeToMinute(inTime);
                addTime(result, carNumber, subTime);
            }

            answer = new int[result.size()];

            List<Integer> tempSet = new ArrayList<>(result.keySet());
            Collections.sort(tempSet);
            for (int i=0; i<result.size(); i++) {
                Integer carNumber = tempSet.get(i);
                int carTime = result.get(carNumber);
                if (carTime <= fees[0]) {
                    answer[i] = fees[1];
                } else {
                    int subCarTime = carTime - fees[0];
                    int countValue = subCarTime/fees[2];
                    if (subCarTime%fees[2] != 0) {
                        countValue++;
                    }
                    answer[i] = fees[1] + (countValue*fees[3]);
                }
            }

            return answer;
        }

        private int convertTimeToMinute(String time) {
            String[] splitTime = time.split(":");
            return Integer.parseInt(splitTime[1]) + (Integer.parseInt(splitTime[0])*60);
        }

        private void addTime(HashMap<Integer, Integer> result, String carNumber, int time) {
            int intCarNumber = Integer.parseInt(carNumber);
            if (!result.containsKey(intCarNumber)) {
                result.put(intCarNumber, 0);
            }
            result.put(intCarNumber, result.get(intCarNumber)+time);
        }

    }
}
