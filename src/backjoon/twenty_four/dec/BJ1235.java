package backjoon.twenty_four.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ids = new String[N];
        for(int i=0; i<N; i++) {
            ids[i] = br.readLine();
        }
        int idSize = ids[0].length();
        int answer = 0;

        for (int i=1; i<=idSize; i++) {
            Set<String> stringSet = new HashSet<>();
            for (int j=0; j<N; j++) {
                stringSet.add(ids[j].substring(idSize-i, idSize));
            }

            if (stringSet.size() == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }
}
