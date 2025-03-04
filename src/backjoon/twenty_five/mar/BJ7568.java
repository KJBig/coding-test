package backjoon.twenty_five.mar;

import java.io.*;
import java.util.*;

public class BJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] members = new int[N][4];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            members[i][0] = i;
            members[i][1] = Integer.parseInt(input[0]);
            members[i][2] = Integer.parseInt(input[1]);
        }

        Arrays.sort(members, Comparator.comparing((int[] member) -> member[1]+member[2], Comparator.reverseOrder()));

        members[0][3] = 1;
        for (int i=1; i<N; i++) {
            int count = 1;
            for (int j=0; j<i; j++) {
                if ((members[j][1] > members[i][1]) && (members[j][2] > members[i][2])) {
                    count++;
                }
            }
            members[i][3] = count;
        }

        for (int i=0; i<N; i++) {
            System.out.print(members[i][0] + " " + members[i][1] + " " + members[i][2] + " " + members[i][3]);
            System.out.println();
        }

        Arrays.sort(members, Comparator.comparing((int[] member) -> member[0]));

        for (int i=0; i<N; i++) {
            System.out.print(members[i][3] + " ");
        }

    }

}
