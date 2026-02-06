package backjoon.twenty_six.feb;

import java.io.*;
import java.util.*;

public class BJ12920 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int M = Integer.parseInt(init[1]);

        List<Item> items = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] itemInput = br.readLine().split(" ");
            int V = Integer.parseInt(itemInput[0]);
            int C = Integer.parseInt(itemInput[1]);
            int K = Integer.parseInt(itemInput[2]);

            int p = 1;
            while (K > 0) {
                int cnt = Math.min(p, K);
                items.add(new Item(V * cnt, C * cnt));
                K -= cnt;
                p = p * 2;
            }
        }

        int[] dp = new int[M + 1];

        for (Item item : items) {
            for (int w=M; w>=item.w; w--) {
                dp[w] = Math.max(dp[w], dp[w-item.w] + item.v);
            }
        }

        System.out.println(dp[M]);
    }

    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

}
