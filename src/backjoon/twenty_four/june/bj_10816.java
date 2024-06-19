package backjoon.twenty_four.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] myCardInput = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] cardInput = br.readLine().split(" ");

        int[] myCards = new int[N];
        int[] cards = new int[M];
        for (int i=0; i<N; i++) {
            myCards[i] = Integer.parseInt(myCardInput[i]);
        }

        for (int i=0; i<M; i++) {
            cards[i] = Integer.parseInt(cardInput[i]);
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(myCards);

        for (int i=0; i<M; i++) {
            int start = 0;
            int end = N-1;
            while (start <= end) {
                int mid = (start+end)/2;
                if (myCards[mid] > cards[i]) {
                    end = mid-1;
                } else if (myCards[mid] < cards[i]) {
                    start = mid+1;
                } else {
                    sb.append(getRightCardNum(myCards, myCards[mid]) - getLeftCardNum(myCards, myCards[mid])).append(" ");
                    break;
                }
            }

            if (start > end) {
                sb.append("0 ");
            }
        }

        System.out.println(sb);

    }

    private static int getLeftCardNum(int[] myCards, int target) {
        int start = 0;
        int end = myCards.length;
        int mid;
        while(start < end) {

            mid = (start+end)/2;

            if(target <= myCards[mid]) {
                end = mid;
            }else {
                start = mid + 1;
            }

        }

        return start;

    }

    private static int getRightCardNum(int[] myCards, int target) {
            int start = 0;
            int end = myCards.length;
            int mid;

            while(start < end) {

                mid = (start+end)/2;

                if(target < myCards[mid]) {
                    end = mid;
                }else {
                    start = mid + 1;
                }

            }

            return start;
    }
}
