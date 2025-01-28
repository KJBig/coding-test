package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> crains = new ArrayList<>();
        String[] crainInput = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            crains.add(Integer.parseInt(crainInput[i]));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> containers = new ArrayList<>();
        String[] containerInput = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            containers.add(Integer.parseInt(containerInput[i]));
        }

        crains.sort(Comparator.reverseOrder());
        containers.sort(Comparator.reverseOrder());

        if(crains.get(0)<containers.get(0)){
            System.out.println(-1);
            return;
        }

        int answer = 0;

        while(!containers.isEmpty()){
            int boxIdx = 0, craneIdx = 0;

            while(craneIdx<N){
                if(boxIdx == containers.size())
                    break;
                else if(crains.get(craneIdx) >= containers.get(boxIdx)){
                    containers.remove(boxIdx);
                    craneIdx++;
                }
                else
                    boxIdx++;
            }

            answer++;
        }

        System.out.println(answer);

    }
}
