package backjoon.twenty_five.dec;

import java.io.*;

public class BJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(input[0]);
            points[i][1] = Integer.parseInt(input[1]);
        }

        long answer;
        long front = 0L;
        long back = 0L;

        for (int i=0; i<N-1; i++) {
            front += (long) points[i][0]*points[i+1][1];
            back += (long) points[i][1]*points[i+1][0];
        }
        front += (long) points[N-1][0]*points[0][1];
        back += (long) points[N-1][1]*points[0][0];

        answer = Math.abs(front - back);

        if (answer % 2 == 0) {
            System.out.println((answer / 2) + ".0");
        } else {
            System.out.println((answer / 2) + ".5");
        }
    }
}
