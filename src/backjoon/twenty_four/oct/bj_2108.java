package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class bj_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<N; i++) {
            Integer input = Integer.parseInt(br.readLine());
            numbers.add(input);
            sum += input;
            min = Math.min(min, input);
            max = Math.max(max, input);

            if (!hashMap.containsKey(input)) {
                hashMap.put(input, 0);
            }
            hashMap.put(input, hashMap.get(input)+1);
        }

        numbers.sort(Comparator.naturalOrder());

        int manyCount = 0;
        for (Integer integer : hashMap.keySet()) {
            manyCount = Math.max(manyCount, hashMap.get(integer));
        }

        List<Integer> elements = new ArrayList<>();

        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) == manyCount) {
                elements.add(integer);
            }
        }

        elements.sort(Comparator.naturalOrder());
        int answer = elements.get(0);
        if (elements.size() > 1) {
            answer = elements.get(1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(Double.parseDouble(String.valueOf(sum))/N)).append("\n");
        sb.append(numbers.get(numbers.size()/2)).append("\n");
        sb.append(answer    ).append("\n");
        sb.append(max-min);


        System.out.println(sb);

    }

}
