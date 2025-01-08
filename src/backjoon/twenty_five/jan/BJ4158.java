package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            if (N == 0 && M == 0) {
                break;
            }

            int[] sang = new int[N];
            int[] sun = new int[M];

            for (int i = 0; i < N; i++) {
                int number = Integer.parseInt(br.readLine());
                sang[i] = number;
            }

            for (int i = 0; i < M; i++) {
                int number = Integer.parseInt(br.readLine());
                sun[i] = number;
            }

            int answer;
            if (N < M) {
                answer = countSameNumber(sang, sun);
            } else {
                answer = countSameNumber(sun, sang);
            }

            System.out.println(answer);
        }

    }

    private static int countSameNumber(int[] now, int[] target) {
        int result = 0;
        for (int i=0; i<now.length; i++) {
            boolean isContains = binarySearch(now[i], target);
            if (isContains) {
                result++;
            }
        }
        return result;
    }

    private static boolean binarySearch(int num, int[] target) {
        int start=0;
        int end=target.length-1;
        while (start<=end) {
            int mid=(start+end)/2;
            if (num == target[mid]) {
                return true;
            }
            if (num < target[mid]) {
                end = mid-1;
            }
            if (num > target[mid]) {
                start = mid+1;
            }
        }
        return false;
    }
}
