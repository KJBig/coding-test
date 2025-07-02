package backjoon.twenty_five.jul;

import java.io.*;

public class BJ13397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] arr = new int[N];

        String[] numbers = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(numbers[i]);
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int left = 0;
        int right = max - min;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int curMin = arr[0];
            int curMax = arr[0];
            int cut = 1;

            for(int i = 1; i < N; i++){
                curMin = Math.min(curMin, arr[i]);
                curMax = Math.max(curMax, arr[i]);

                if(curMax - curMin > mid){
                    cut++;
                    curMin = arr[i];
                    curMax = arr[i];
                }
            }

            if(cut <= M) {
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}