package backjoon.twenty_four.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class bj_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=1; i<=N; i++){
            result += checkHanNumber(i);
        }
        System.out.println(result);
    }

    private static int checkHanNumber(int number) {
        if(number < 100){
            return 1;
        }
        List<Integer> numbers = Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .toList();
        int difference = numbers.get(0) - numbers.get(1);

        for(int i=2; i<numbers.size(); i++){
            int nowDifference = numbers.get(i - 1) - numbers.get(i);
            if(difference != nowDifference){
                return 0;
            }
        }
        return 1;
    }
}
