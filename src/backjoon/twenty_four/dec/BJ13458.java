package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomSize = Integer.parseInt(br.readLine());
        int[] rooms = new int[roomSize];
        String[] studentNumbers = br.readLine().split(" ");
        for (int i=0; i<roomSize; i++) {
            rooms[i] = Integer.parseInt(studentNumbers[i]);
        }

        String[] coverSize = br.readLine().split(" ");
        int main = Integer.parseInt(coverSize[0]);
        int sub = Integer.parseInt(coverSize[1]);

        long answer = 0;

        for (int i=0; i<roomSize; i++) {
            rooms[i] -= main;
            answer++;
            if (rooms[i] > 0) {
                int subCount = rooms[i] / sub;
                answer += subCount;
                if (rooms[i]%sub != 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
