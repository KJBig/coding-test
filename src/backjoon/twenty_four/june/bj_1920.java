package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String[] aInput = br.readLine().split(" ");
        int b = Integer.parseInt(br.readLine());
        String[] bInput = br.readLine().split(" ");

        int[] aNumbers = new int[a];
        int[] bNumbers = new int[b];

        for (int i=0; i<a; i++) {
            aNumbers[i] = Integer.parseInt(aInput[i]);
        }
        Arrays.sort(aNumbers);

        for (int i=0; i<b; i++) {
            bNumbers[i] = Integer.parseInt(bInput[i]);
        }

        for (int i=0; i<b; i++) {
            int start = 0;
            int end = a-1;
            int target = bNumbers[i];
            boolean flag = false;
            while (start <= end) {
                int mid = (start+end)/2;

                if (target > aNumbers[mid]) {
                    start = mid+1;
                } else if (target < mid) {
                    end = mid-1;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }


    }
}
