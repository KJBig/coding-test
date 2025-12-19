package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase=0; testCase<T; testCase++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            List<Integer> inputNumbers = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());

            for (int k=0; k<(N/10)+1; k++) {
                String[] split = br.readLine().split(" ");
                for (int i=0; i<split.length; i++) {
                    inputNumbers.add(Integer.parseInt(split[i]));
                }
            }

            int[] numbers = new int[N];
            for (int i=0; i<N; i++) {
                numbers[i] = inputNumbers.get(i);
            }

            PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>();

            for (int i=1; i<=N; i++) {
                int nowNumber = numbers[i-1];
                maxQueue.add(nowNumber);

                while (maxQueue.size()-minQueue.size() != 1) {
                    if (maxQueue.size() == minQueue.size()) {
                        break;
                    }
                    if (maxQueue.size() > minQueue.size()) {
                        minQueue.add(maxQueue.poll());
                    } else if (maxQueue.size() < minQueue.size()){
                        maxQueue.add(minQueue.poll());
                    }
                }

                while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() < minQueue.peek()) {
                    Integer minPoll = minQueue.poll();
                    Integer maxPoll = maxQueue.poll();

                    minQueue.add(maxPoll);
                    maxQueue.add(minPoll);
                }

                if (i%2 != 0) {
                    if (count!=0 && count%10 == 0) {
                        sb.append(" \n");
                    }

                    if (maxQueue.isEmpty()) {
                        sb.append(minQueue.peek()).append(" ");
                        count++;
                    } else {
                        sb.append(maxQueue.peek()).append(" ");
                        count++;
                    }
                }
            }

            System.out.println(count);
            System.out.println(sb);

        }
    }

}