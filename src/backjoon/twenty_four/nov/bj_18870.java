package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> workspace = new ArrayList<>();

        for (int i=0; i<N; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        workspace.addAll(numbers);
        workspace.sort(Comparator.naturalOrder());

        int index = 0;
        for (int i=0; i<N; i++) {
            Integer key = workspace.get(i);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, index);
                index++;
            }
        }


        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            sb.append(hashMap.get(numbers.get(i))).append(" ");
        }

        System.out.println(sb);

    }
}
