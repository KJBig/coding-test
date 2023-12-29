package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1940 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        String[] numberStrs = scanner.nextLine().split(" ");
        int[] numbers = new int[N];

        for (int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }

        Arrays.sort(numbers);

        int start = 0;
        int end = N-1;
        int count = 0;

        while(start < end){
            if(numbers[start] + numbers[end] > M){
                end--;
            }else if(numbers[start] + numbers[end] < M){
                start++;
            }else{
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);

    }
}
