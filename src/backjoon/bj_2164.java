package backjoon;

import java.io.*;
import java.util.*;

public class bj_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i=N; i>=1; i--){
            deque.push(i);
        }

        while(deque.size() != 1){
            // 맨위에 카드 땅에 버리기
            deque.pop();
            deque.addLast(deque.pop());
        }
        System.out.println(deque.pop());

    }
}
