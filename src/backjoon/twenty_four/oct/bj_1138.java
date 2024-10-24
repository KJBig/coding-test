package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> processor = new ArrayList<>();

        for (int i=N-1; i>=0; i--) {
            processor.add(Integer.parseInt(input[i]), i+1);
        }

        for (Integer integer : processor) {
            System.out.print(integer + " ");
        }

    }

}
