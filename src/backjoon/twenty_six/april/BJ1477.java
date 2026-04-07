package backjoon.twenty_six.april;

import java.io.*;
import java.util.*;

public class BJ1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initInput = br.readLine().split(" ");
        int N = Integer.parseInt(initInput[0]);
        int M = Integer.parseInt(initInput[1]);
        int L = Integer.parseInt(initInput[2]);

        int[] restAreas = new int[N+2];

        restAreas[0] = 0;
        restAreas[N+1] = L;

        String[] restAreaLocations = br.readLine().split(" ");
        for (int i=1; i<=N; i++) {
            restAreas[i-1] = Integer.parseInt(restAreaLocations[i-1]);
        }

        Arrays.sort(restAreas);

        int start = 1;
        int end = L-1;
        int answer = L;

        while (start <= end) {
            int mid = (start+end)/2;

            int count = 0;
            for (int i=1; i<=(N+1); i++) {
                int dist = restAreas[i] - restAreas[i-1];
                count += (dist-1) / mid;
            }

            if (count > M) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
