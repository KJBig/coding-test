package backjoon.twenty_five.nov;

import java.io.*;
import java.util.*;

public class BJ13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int power = 0;
            PriorityQueue<Long> queue = new PriorityQueue<>();
            String[] numbers = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                queue.add(Long.parseLong(numbers[j]));
            }

            while (queue.size() != 1) {
                long poll1 = queue.poll();
                long poll2 = queue.poll();

                long sumPower = poll1+poll2;
                queue.add(sumPower);
                power += sumPower;
                // System.out.println(poll1 + " + " + poll2 + " ... sum " + power);
            }

            System.out.println(power);

        }

    }

}