package backjoon.twenty_five.apr;

import java.io.*;

public class BJ12099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int Q = Integer.parseInt(initInput[1]);

        int[][] menus = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] menuInput = br.readLine().split(" ");
            int spa = Integer.parseInt(menuInput[0]);
            int sweet = Integer.parseInt(menuInput[1]);
            menus[i][0] = spa;
            menus[i][1] = sweet;
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<Q; i++) {
            String[] dayInput = br.readLine().split(" ");
            int spaStart = Integer.parseInt(dayInput[0]);
            int spaEnd = Integer.parseInt(dayInput[1]);
            int sweetStart = Integer.parseInt(dayInput[2]);
            int sweetEnd = Integer.parseInt(dayInput[3]);
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (menus[j][0] >= spaStart && menus[j][0] <= spaEnd && menus[j][1] >= sweetStart && menus[j][1] <= sweetEnd) {
                    count++;
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }
}
