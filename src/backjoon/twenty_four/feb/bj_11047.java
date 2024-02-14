package backjoon.twenty_four.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bj_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int count = 0;
        List<Integer> coins = new ArrayList<>();

        for (int i=0; i<N; i++){
            coins.add(Integer.parseInt(br.readLine()));
        }
        coins.sort(Comparator.reverseOrder());
        int i=0;
        while(K>0){
            if(coins.get(i) <= K){
                K -= coins.get(i);
                count++;
                continue;
            }
            i++;
        }
        System.out.println(count);
    }
}
