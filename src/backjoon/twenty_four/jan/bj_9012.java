package backjoon.twenty_four.jan;

import java.io.*;
import java.util.Stack;

public class bj_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            Stack<Integer> stack = new Stack<>();
            String[] split = br.readLine().split("");
            for (String str : split) {
                if(str.equals("(")){
                    stack.push(1);
                }else {
                    if(stack.isEmpty()){
                        stack.push(1);
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
