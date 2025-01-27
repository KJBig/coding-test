package backjoon.twenty_five.jan;

import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class BJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        if(K >= N) {
            System.out.println(0);
            return;
        }

        List<Integer> subNumbers = new ArrayList<>();

        for (int i=0; i<N-1; i++) {
            subNumbers.add(numbers[i+1] - numbers[i]);
        }

        subNumbers.sort(Comparator.naturalOrder());

        for (int i=0; i<K-1; i++) {
            subNumbers.remove(subNumbers.size()-1);
        }
        int answer = 0;

        for (Integer subNumber : subNumbers) {
            answer += subNumber;
        }

        System.out.println(answer);

    }


}

