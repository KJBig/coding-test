package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] students = new int[N];

        for (int i=0; i<N; i++) {
            students[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(students);
        long answer = 0;

        for (int i=0; i<N; i++) {
            if (students[i] > 0) break;
            int start = i+1;
            int end = N-1;

            while (start < end) {
                int s = 1;
                int e = 1;
                int current = students[i] + students[start] + students[end];
                if (current == 0) {
                    if (students[start] == students[end]) {
                        answer += comb(end-start+1);
                        break;
                    }

                    while ((start+1 < end) && (students[start] == students[start+1])) {
                        s++;
                        start++;
                    }

                    while ((start < end-1) && (students[end] == students[end-1])) {
                        e++;
                        end--;
                    }

                    answer += s*e;
                }

                if (current > 0){
                    end--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(answer);
    }


    static int comb(int n) {
        return n * (n-1) / 2;
    }


}
