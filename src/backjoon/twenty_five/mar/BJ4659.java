package backjoon.twenty_five.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BJ4659 {

    static String ACCEPT_MESSAGE = "> is acceptable.";
    static String NOT_ACCEPT_MESSAGE = "> is not acceptable.";

    static List<Character> mos = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            int moCount = 0;
            int seqCount = 0;
            int duplCount = 0;
            char before = '-';
            boolean isJa = true;
            boolean isAccept = true;
            if (str.equals("end")) {
                break;
            }

            for (int i=0; i<str.length(); i++) {
                char now = str.charAt(i);

                // 같은 글자 연속 두번 등장 검열
                if (before == now) {
                    if (now == 'e' || now == 'o') {
                        if (duplCount >= 2){
                            isAccept = false;
                            break;
                        }
                        duplCount++;

                    } else {
                        isAccept = false;
                        break;
                    }
                }


                // 3번 연속 검열
                if (mos.contains(now)) {
                    moCount++;
                    if (!isJa) {
                        seqCount++;
                    } else {
                        isJa = false;
                        seqCount = 1;
                    }
                } else {
                    if (isJa) {
                        seqCount++;
                    } else {
                        isJa = true;
                        seqCount = 1;
                    }

                }

                if (seqCount == 3) {
                    isAccept = false;
                    break;
                }

                before=now;

            }

            if (moCount == 0) {
                isAccept = false;
            }

            if (isAccept) {
                sb.append("<").append(str).append(ACCEPT_MESSAGE).append("\n");
            } else {
                sb.append("<").append(str).append(NOT_ACCEPT_MESSAGE).append("\n");
            }

        }

        System.out.println(sb);
    }
}
