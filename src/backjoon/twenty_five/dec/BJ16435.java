package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int L = Integer.parseInt(init[1]);

        String[] foodInput = br.readLine().split(" ");
        PriorityQueue<Integer> foods = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            foods.add(Integer.parseInt(foodInput[i]));
        }

        while (!foods.isEmpty()) {
            Integer food = foods.poll();
            if (food <= L) {
                L++;
            } else {
                break;
            }
        }

        System.out.println(L);
    }
}
