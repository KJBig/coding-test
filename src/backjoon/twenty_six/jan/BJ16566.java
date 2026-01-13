package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16566 {

    static int[] PARENT;
    static int[] CARDS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        CARDS = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            CARDS[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(CARDS);

        PARENT = new int[M+1];
        for (int i=0; i<=M; i++) {
            PARENT[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<K; i++) {
            int now = Integer.parseInt(st.nextToken());

            int index = upperBound(CARDS, now);
            index = find(index);

            sb.append(CARDS[index]).append('\n');
            union(index, index + 1);
        }

        System.out.print(sb);
    }

    static int upperBound(int[] arr, int now) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= now) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int find(int x) {
        if (PARENT[x] == x) {
            return x;
        }
        return PARENT[x] = find(PARENT[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        PARENT[a] = b;
    }
}
