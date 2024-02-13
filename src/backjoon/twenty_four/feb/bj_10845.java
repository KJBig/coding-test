package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class bj_10845 {
    private static Deque<Integer> QUEUE = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            String order = split[0];
            Integer number = null;
            if(containNumber(order)) {
                number = Integer.parseInt(split[1]);
            }
            queueProcessing(order, number);
        }
    }

    private static void queueProcessing(String order, Integer number) {
        switch (order){
            case "push" : QUEUE.add(number); break;
            case "pop" : popQueue(); break;
            case "size" : System.out.println(QUEUE.size()); break;
            case "empty" : isEmptyQueue(); break;
            case "front" : frontQueue(); break;
            case "back" : backQueue(); break;

        }
    }

    private static void backQueue() {
        if(QUEUE.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(QUEUE.getLast());
        }
    }

    private static void frontQueue() {
        if(QUEUE.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(QUEUE.getFirst());
        }
    }

    private static void isEmptyQueue() {
        if (QUEUE.isEmpty()){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    private static void popQueue() {
        if(QUEUE.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(QUEUE.poll());
        }
    }

    private static boolean containNumber(String order) {
        return order.equals("push");
    }
}
