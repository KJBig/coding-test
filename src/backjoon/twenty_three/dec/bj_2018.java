package backjoon.twenty_three.dec;

import java.util.Scanner;

public class bj_2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;
        while(end < N){
            if(sum == N){
                count++;
                end++;
                sum+=end;
            }else if(sum>N){
                sum-=start;
                start++;
            }else{
                end++;
                sum+=end;
            }
        }
        System.out.println(count);
    }
}
