package backjoon.twenty_five.mar;

import java.io.*;
import java.util.*;

public class BJ25757 {
    static HashMap<String, Integer> PLAYER_NUMBER = new HashMap<>();
    static Set<String> ATTEND_MEMBERS = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PLAYER_NUMBER.put("Y", 1);
        PLAYER_NUMBER.put("F", 2);
        PLAYER_NUMBER.put("O", 3);

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int playerNumber = PLAYER_NUMBER.get(input[1]);

        for (int i=0; i<N; i++) {
            String playerName = br.readLine();
            ATTEND_MEMBERS.add(playerName);
        }

        System.out.println(ATTEND_MEMBERS.size()/playerNumber);

    }
}
