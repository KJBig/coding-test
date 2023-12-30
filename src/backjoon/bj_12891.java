package backjoon;

import java.util.Scanner;

public class bj_12891 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] configNumbers = scanner.nextLine().split(" ");
        int S = Integer.parseInt(configNumbers[0]);
        int P = Integer.parseInt(configNumbers[1]);

        String[] dnaStr = scanner.nextLine().split("");
        String[] limitNum = scanner.nextLine().split(" ");
        int[] answer = new int[4];

        answer[0] = Integer.parseInt(limitNum[0]);
        answer[1] = Integer.parseInt(limitNum[1]);
        answer[2] = Integer.parseInt(limitNum[2]);
        answer[3] = Integer.parseInt(limitNum[3]);



        int start = 0;
        int end = P - 1;
        int count = 0;

        for(int i = start; i<=end; i++){
            answer[convertNumber(dnaStr[i])]--;
        }

        count = checkCount(answer, count);

        while(end < S-1){
            answer[convertNumber(dnaStr[start])]++;
            start++;
            end++;
            answer[convertNumber(dnaStr[end])]--;
            count = checkCount(answer, count);
        }

        System.out.println(count);

    }

    private static int checkCount(int[] answer, int count) {
        int temp = 0;
        for(int i=0; i<4; i++){
            if(answer[i] <= 0){
                temp++;
            }
        }
        if(temp == 4){
            count++;
        }
        return count;
    }

    private static int convertNumber(String str){
        int number = 0;
        if (str.equals("A")){
            number = 0;
        }
        if (str.equals("C")){
            number = 1;
        }
        if (str.equals("G")){
            number = 2;
        }
        if (str.equals("T")){
            number = 3;
        }

        return number;
    }
}
