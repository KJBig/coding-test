package backjoon.twenty_six.april;

import java.io.*;
import java.util.Arrays;

public class BJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int K = Integer.parseInt(initInput[0]);
        int N = Integer.parseInt(initInput[1]);
        int[] lines = new int[K];

        for (int i=0; i<K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lines);

        long start = 1;
        long end = lines[K-1];

        while (start<=end) {
            long mid = (start+end)/2;
            System.out.println("start: " + start+ ", end: "+end+", mid: " + mid);
            int count = 0;
            for (int i=0; i<K; i++) {
                count += (int) (lines[i]/mid);
            }

            if (count >= N) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(end);

    }
}
