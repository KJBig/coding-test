package backjoon.twenty_five.jul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i< N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        int value=0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i =0; i<W ; i++) {
            bridge.add(0);
        }
        while(!bridge.isEmpty()) {
            time++;
            value-=bridge.poll();
            if(!truck.isEmpty()) {
                if(truck.peek()+value<=L) {
                    value+=truck.peek();
                    bridge.offer(truck.poll());
                }else {
                    bridge.offer(0);
                }
            }
        }
        System.out.println(time);


    }
}
