package backjoon.twenty_four.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj_18258 {

    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push" : {
                    queue.addLast(Integer.parseInt(input[1])); break;
                }
                case "pop" : {
                    int num;
                    try {
                        num = queue.pollFirst();
                    } catch (Exception e) {
                        num = -1;
                    }
                    sb.append(num).append("\n");
                    break;
                }
                case "size" : {
                    sb.append(queue.size()).append("\n"); break;
                }
                case "empty" : {
                    if (queue.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                }
                case "front" : {
                    Integer integer = queue.peekFirst();
                    if (integer == null) {
                        integer = -1;
                    }
                    sb.append(integer).append("\n"); break;
                }
                case "back" : {
                    Integer integer = queue.peekLast();
                    if (integer == null) {
                        integer = -1;
                    }
                    sb.append(integer).append("\n"); break;
                }
            }
        }

        System.out.println(sb);
    }
}
