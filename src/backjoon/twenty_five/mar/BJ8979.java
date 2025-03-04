package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int[][] cons = new int[N][4];

        for (int i=0; i<N; i++) {
            String[] conInput = br.readLine().split(" ");
            for (int j=0; j<4; j++) {
                cons[i][j] = Integer.parseInt(conInput[j]);
            }
        }

        Arrays.sort(cons, Comparator.comparing((int[] con)-> con[1], Comparator.reverseOrder())
                .thenComparing((int[] con) -> con[2], Comparator.reverseOrder())
                .thenComparing((int[] con) -> con[3], Comparator.reverseOrder())
        );

        for (int i=0; i<N; i++) {
            if (cons[i][0] == target) {
                int index = i+1;
                for (int j=0; j<i; j++) {
                    if ((cons[j][1] == cons[i][1]) && (cons[j][2] == cons[i][2]) && (cons[j][3] == cons[i][3])) {
                        index = j+1;
                        break;
                    }
                }
                System.out.println(index);
                break;
            }
        }
    }
}
