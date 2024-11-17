package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> dp = new ArrayList<>();

        dp.add(numbers[0]);
        int nowIndex = 0;
        for (int i=1; i<N; i++) {
            if (numbers[i] > dp.get(nowIndex)) {
                nowIndex++;
                dp.add(numbers[i]);
            } else {
                int index = binary_search(dp, numbers[i]);
                dp.set(index, numbers[i]);
            }
        }

        System.out.println(dp.size());

    }

    private static int binary_search(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
