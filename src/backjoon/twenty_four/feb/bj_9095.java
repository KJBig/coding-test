package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] caseCount = new int[12];
        caseCount[1] = 1;
        caseCount[2] = 2;
        caseCount[3] = 4;

        for(int i=4; i<=11; i++){
            caseCount[i] = caseCount[i-1] + caseCount[i-2] + caseCount[i-3];
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(caseCount[n]);
        }
    }
}
