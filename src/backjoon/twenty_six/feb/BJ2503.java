package backjoon.twenty_six.feb;

import java.io.*;

public class BJ2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Hint[] hints = new Hint[N];
        for (int i=0; i<N; i++) {
            String[] hintInput = br.readLine().split(" ");
            String number = hintInput[0];
            int strike = Integer.parseInt(hintInput[1]);
            int ball = Integer.parseInt(hintInput[2]);
            hints[i] = new Hint(number, strike, ball);
        }

        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            String number = String.valueOf(i);

            if (number.contains("0")) {
                continue;
            }

            if (number.charAt(0) == number.charAt(1) ||
                    number.charAt(1) == number.charAt(2) ||
                    number.charAt(0) == number.charAt(2)) {
                continue;
            }

            boolean isPossible = true;
            for (int k = 0; k < hints.length; k++) {
                Hint hint = hints[k];
                int strikeCount = getStrikeCount(number, hint.number);
                int ballCount = getBallCount(number, hint.number);

                if (strikeCount != hint.strike || ballCount != hint.ball) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int getBallCount(String number, String target) {
        int ballCount = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == j) {
                    continue;
                }

                if (number.charAt(i) == target.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private static int getStrikeCount(String number, String target) {
        int strikeCount = 0;
        for (int i=0; i<3; i++) {
            if (number.charAt(i) == target.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    static class Hint {
        String number;
        int strike;
        int ball;

        public Hint(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

}
