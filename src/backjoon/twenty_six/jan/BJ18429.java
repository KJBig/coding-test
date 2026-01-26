package backjoon.twenty_six.jan;

import java.io.*;

public class BJ18429 {

    static int N, K;
    static int[] NUMBERS;
    static boolean[] VISITED;
    static int ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInput = br.readLine().split(" ");
        N = Integer.parseInt(initInput[0]);
        K = Integer.parseInt(initInput[1]);

        String[] numberInput = br.readLine().split(" ");
        NUMBERS = new int[N];
        for (int i=0; i<N; i++) {
            NUMBERS[i] = Integer.parseInt(numberInput[i]);
        }

        VISITED = new boolean[N];
        ANSWER = 0;
        back(500, 0);
        System.out.println(ANSWER);
    }

    static void back(int sum, int idx) {
        if (idx == N) {
            ANSWER++;
            return;
        }

        for (int i=0; i<N; i++) {
            if (!VISITED[i] && (sum+NUMBERS[i]-K) >= 500) {
                VISITED[i] = true;
                back(sum + NUMBERS[i] - K, idx + 1);
                VISITED[i] = false;
            }
        }
    }
}
