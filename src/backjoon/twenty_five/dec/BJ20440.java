package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> timeMap = new HashMap<>();


        // 좌표 기반 모기 입출장 저장
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (!timeMap.containsKey(start)) {
                timeMap.put(start, 0);
            }

            if (!timeMap.containsKey(end)) {
                timeMap.put(end, 0);;
            }
            timeMap.put(start, timeMap.get(start)+1);
            timeMap.put(end, timeMap.get(end)-1);
        }

        // 좌표를 기반으로 누적의 합 계산
        List<Integer> times = timeMap.keySet().stream().sorted().toList();
        int[] count = new int[times.size()];
        int[] startTime = new int[times.size()];

        count[0] = timeMap.get(times.get(0));
        startTime[0] = times.get(0);
        for (int i=1; i<times.size(); i++) {
            count[i] = count[i-1] + timeMap.get(times.get(i));
            startTime[i] = times.get(i);
        }

        // 최댓값 및 구간 찾기
        int max = 0;
        int maxIndex = 0;
        for (int i=0; i<times.size(); i++) {
            if (max < count[i]) {
                max = count[i];
                maxIndex = i;
            }
        }

        int endIndex = maxIndex;
        while (count[endIndex] == count[maxIndex]) {
            endIndex++;
        }

        // 출력
        System.out.println(max);
        System.out.println(startTime[maxIndex] + " " + startTime[endIndex]);

    }
}
