package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class bj_1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] order = new int[N];
        for(int i=0; i<N; i++){
            order[i] = Integer.parseInt(scanner.nextLine());
        }
        List<String> result = new ArrayList<>();
        int now = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<=N; i++){
            if(!stack.isEmpty() && stack.lastElement() == order[now]){
                stack.pop();
                now++;
                result.add("-");
                i--;
                continue;
            }

            stack.push(i);
            result.add("+");
        }

        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                if(stack.lastElement() == order[now]){
                    stack.pop();
                    now++;
                    result.add("-");
                }else{
                    result.clear();
                    result.add("NO");
                    break;
                }
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
