package backjoon.twenty_five.aug;

import java.io.*;
import java.util.*;

public class BJ5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][4];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }

        Arrays.sort(arr, Comparator
                .comparing((String[] o) -> Integer.parseInt(o[3]))
                .thenComparing(o -> Integer.parseInt(o[2]))
                .thenComparing(o -> Integer.parseInt(o[1])));

        System.out.println(arr[n - 1][0]);
        System.out.println(arr[0][0]);
    }
}
