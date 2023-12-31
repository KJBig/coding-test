package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        String[] numberStr = bf.readLine().split(" ");
        int[] numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(numberStr[i]);
        }
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<N; i++) {
            while(!stack.isEmpty() && numbers[stack.lastElement()] < numbers[i]){
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.empty()){
            result[stack.pop()] = -1;
        }

        for (int i : result) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
