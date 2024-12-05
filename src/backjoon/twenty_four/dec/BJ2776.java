package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(target);
            int M = Integer.parseInt(br.readLine());
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j=0; j<M; j++) {
                if (isContains(N, target, now[j])) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);

    }

    private static boolean isContains(int N, int[] target, int now) {
        int start = 0;
        int end = N-1;
        while (start<=end) {
            int mid = (start+end)/2;
            int midNum = target[mid];

            if (midNum == now) {
                return true;
            }
            if (midNum > now) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
