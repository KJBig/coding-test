package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchSize = Integer.parseInt(br.readLine());
        int[] switchStatus = new int[switchSize+1];

        String[] input = br.readLine().split(" ");

        for (int i=1; i<=switchSize; i++) {
            switchStatus[i] = Integer.parseInt(input[i-1]);
        }

        int studentSize = Integer.parseInt(br.readLine());

        for (int i=0; i<studentSize; i++) {
            String[] studentInput = br.readLine().split(" ");
            int gender = Integer.parseInt(studentInput[0]);
            int card = Integer.parseInt(studentInput[1]);

            if (gender == 1) {
                processMan(switchSize, switchStatus, card);
            }

            if (gender == 2) {
                processWoman(switchSize, switchStatus, card);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=switchSize; i++) {
            sb.append(switchStatus[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void processWoman(int switchSize, int[] switchStatus, int card) {
        int start = card-1;
        int end = card+1;

        while (start > 0 && end < switchSize+1) {
            if (switchStatus[start] != switchStatus[end]) {
                break;
            }
            start--;
            end++;
        }

        for (int i=start+1; i<end; i++) {
            switchStatus[i] = (switchStatus[i]+1)%2;
        }

    }

    private static void processMan(int switchSize, int[] switchStatus, int card) {
        for (int i=card; i<=switchSize; i+=card) {
            switchStatus[i] = (switchStatus[i] + 1) % 2;
        }
    }
}
