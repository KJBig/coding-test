package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ1758 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        long ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] - i <= 0) {
                break;
            }

            ans += arr[i] - i;
        }

        System.out.println(ans);

    }
}
