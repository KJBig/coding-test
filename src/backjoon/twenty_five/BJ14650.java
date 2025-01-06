package backjoon.twenty_five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ14650 {
    static int ANSWER = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dfs(N, 0, new ArrayList<>());

        System.out.println(ANSWER);

    }

    private static void dfs(int n, int size, List<Integer> objects) {
        if (size == n) {
            if (isMO3(objects)) {
                ANSWER++;
            }
            return;
        }

        for (int i=0; i<3; i++) {
            if (size==0 && i==0) {
                continue;
            }
            objects.add(i);
            dfs(n, size+1, objects);
            objects.remove(objects.size()-1);
        }
    }

    private static boolean isMO3(List<Integer> objects) {
        StringBuilder sb = new StringBuilder();
        for (Integer object : objects) {
            sb.append(object);
        }

        if (Integer.parseInt(sb.toString())%3 == 0) {
            return true;
        }
        return false;
    }
}
