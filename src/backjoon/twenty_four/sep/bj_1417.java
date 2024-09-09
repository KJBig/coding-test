package backjoon.twenty_four.sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class bj_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int daSomVoteNum = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i=0; i<N-1; i++) {
            int voteNum = Integer.parseInt(br.readLine());
            queue.add(voteNum);
        }
        Integer maxNum = queue.poll();
        while(maxNum != null && daSomVoteNum <= maxNum) {
            daSomVoteNum++;
            queue.add(maxNum-1);
            answer++;
            maxNum = queue.poll();
        }

        System.out.println(answer);
    }

}
