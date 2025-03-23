package backjoon.twenty_five.mar;

import java.io.*;
import java.util.*;

public class BJ1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a));
        List<int[]> classTimes = new ArrayList<>(); 
        

        for (int i=0; i<N; i++) {
            String[] inputs = br.readLine().split(" ");
            int startTime = Integer.parseInt(inputs[1]);
            int endTime = Integer.parseInt(inputs[2]);
            classTimes.add(new int[]{startTime, endTime});
        }
        
        classTimes.sort(Comparator.comparing(a->a[0]));

        for (int i=0; i<N; i++) {
            int[] nowClassTime = classTimes.get(i);
            int startTime = nowClassTime[0];
            int endTime = nowClassTime[1];
            
            if (priorityQueue.size() == 0) {
                priorityQueue.add(endTime);
            } else {
                int pollEndTime = priorityQueue.poll();
                if (pollEndTime <= startTime) {
                    priorityQueue.add(endTime);
                } else {
                    priorityQueue.add(pollEndTime);
                    priorityQueue.add(endTime);
                }
            }
            
        }
        
        System.out.println(priorityQueue.size());

    }

}


/*
 * queue:  21 25
 * 3
 */