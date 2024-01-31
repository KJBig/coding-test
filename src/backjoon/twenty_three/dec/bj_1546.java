package backjoon.twenty_three.dec;

import java.util.*;

public class bj_1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] numbers = scanner.nextLine().split(" ");
        double result = 0;
        int maxNum = getMaxNum(numbers);

        fixNumber(numbers, maxNum, N);

        result = getAvg(numbers);

        System.out.println(result);
    }

    private static double getAvg(String[] numbers) {
        double sum = 0;
        for (String number : numbers){
            sum += Double.parseDouble(number);
        }
        return sum/numbers.length;
    }

    private static void fixNumber(String[] numbers, int maxNum, int N) {
        for(int i=0; i<N; i++){
            numbers[i] = String.valueOf((Double.parseDouble(numbers[i])/maxNum)*100);
        }
    }

    private static int getMaxNum(String[] numbers){
        int maxNum = 0;
        for(String number : numbers){
            maxNum = Math.max(maxNum, Integer.parseInt(number));
        }
        return maxNum;
    }
}
