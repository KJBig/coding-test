package backjoon.twenty_five.aug;

import java.util.*;
import java.io.*;

public class BJ19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> names = new HashMap<>();
        Rank[] ranks = new Rank[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (names.containsKey(value)) {
                String oldName = names.get(value);
                ranks[i] = new Rank(oldName, value);
            } else {
                ranks[i] = new Rank(name, value);
                names.put(value, name);
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<M; i++) {
            int nowValue = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N;
            int mid = (start+end)/2;
            while (start <= end) {

                if (mid == 0) {
                    sb.append(ranks[0].name).append("\n");
                    break;
                }

                if (ranks[mid].value > nowValue) {

                    if (mid > 0) {
                        if (ranks[mid].value >= nowValue && nowValue > ranks[mid-1].value) {
                            sb.append(ranks[mid].name).append("\n");
                            break;
                        }
                    }
                    end = mid;
                    mid = (start + end) / 2;
                } else if (ranks[mid].value == nowValue) {
                    sb.append(ranks[mid].name).append("\n");
                    break;
                } else {
                    start = mid;
                    mid = (start+end)/2;
                }

            }
        }
        System.out.println(sb);


    }

    static class Rank {
        String name;
        int value;

        public Rank(String name, int value) {
            this.name = name;
            this.value = value;
        }

    }
}
