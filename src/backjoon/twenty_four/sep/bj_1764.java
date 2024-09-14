package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1764 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> mans = new HashSet<>();
        List<String> result = new ArrayList<>();

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        for (int i=0; i<N; i++) {
            mans.add(br.readLine());
        }

        for (int i=0; i<M; i++) {
            String name = br.readLine();
            int before = mans.size();
            mans.add(name);
            if (before == mans.size()) {
                result.add(name);
            }
        }

        result.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        for (int i=0; i<result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb.toString());

    }
}
