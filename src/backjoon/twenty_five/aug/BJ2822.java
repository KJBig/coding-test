package backjoon.twenty_five.aug;

import java.util.*;
import java.io.*;

public class BJ2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] scores = new Integer[8];
        Integer[] temp = new Integer[8];

        int total = 0;
        Integer[] indexes = new Integer[5];
        for (int i=0; i<8; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
            temp[i] = score;
        }

        Arrays.sort(scores, Comparator.reverseOrder());

        for (int i=0; i<5; i++) {
            total += scores[i];

            for (int j=0; j<8; j++) {
                if (Objects.equals(scores[i], temp[j])) {
                    indexes[i] = j+1;
                    break;
                }
            }
        }

        Arrays.sort(indexes, Comparator.naturalOrder());

        System.out.println(total);

        for (int i=0; i<5; i++) {
            System.out.print(indexes[i] + " ");
        }

    }

}
