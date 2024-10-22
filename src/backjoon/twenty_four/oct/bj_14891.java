package backjoon.twenty_four.oct;

import java.io.*;
import java.util.*;

public class bj_14891 {

    static int ROW_SIZE = 4;
    static int COL_SIZE = 8;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Cogwheel> board = new ArrayList<>();

        for (int row=0; row<ROW_SIZE; row++) {
            String[] split = br.readLine().split("");
            List<Integer> values = new ArrayList<>();
            for (int col=0; col<COL_SIZE; col++) {
                values.add(Integer.parseInt(split[col]));
            }
            board.add(new Cogwheel(values));
        }

        int N = Integer.parseInt(br.readLine());
        for (int index=0; index<N; index++){
            String[] inputs = br.readLine().split(" ");
            int targetNum = Integer.parseInt(inputs[0])-1;
            int count = Integer.parseInt(inputs[1]);

            // 3 && 7
            if (count > 0) {
                scanAll(board, targetNum, count);
            } else {
                scanAll(board, targetNum, count);
            }

            processTurn(board);

        }

        // 점수 구하기 및 출력
        System.out.println(getScore(board));
    }

    private static void printStatus(List<Cogwheel> board) {
        for (Cogwheel cogwheel : board) {
            System.out.print(cogwheel.nextTurn + " ");
        }
        System.out.println();
    }

    private static int getScore(List<Cogwheel> board) {
        int sum = 0;
        int score = 1;
        for (Cogwheel cogwheel : board) {
            if (cogwheel.values.get(0) == 1) {
                sum+=score;
            }
            score*=2;
        }
        return sum;
    }

    private static void processTurn(List<Cogwheel> board) {
        for (Cogwheel cogwheel : board) {
            if (cogwheel.nextTurn==null) {
                continue;
            }
            if (cogwheel.nextTurn>0) {
                turnRight(cogwheel);
            }else {
                turnLeft(cogwheel);
            }
            cogwheel.nextTurn = null;
        }
    }

    private static void scanAll(List<Cogwheel> board, int targetNum, int count) {
        Cogwheel cogwheel = board.get(targetNum);
        cogwheel.nextTurn = count;
        scanRight(board, targetNum, count*-1);
        scanLeft(board, targetNum, count*-1);
    }

    private static void scanRight(List<Cogwheel> board, int beforeTarget, int count) {
        int targetNum = beforeTarget+1;
        while (targetNum <= 3) {
            Cogwheel before = board.get(beforeTarget);
            Cogwheel now = board.get(targetNum);
            if (!before.values.get(2).equals(now.values.get(6))) {
                now.nextTurn = count;
                beforeTarget = targetNum;
                targetNum++;
                count*=-1;
            } else  {
                break;
            }
        }
    }

    private static void scanLeft(List<Cogwheel> board, int beforeTarget, int count) {
        int targetNum = beforeTarget-1;
        while (targetNum >= 0) {
            Cogwheel before = board.get(beforeTarget);
            Cogwheel now = board.get(targetNum);
            if (!before.values.get(6).equals(now.values.get(2))) {
                now.nextTurn = count;
                beforeTarget = targetNum;
                targetNum--;
                count*=-1;
            } else  {
                break;
            }
        }
    }




    /*========*/

    private static void printBoard(List<Cogwheel> board) {
        System.out.println("=========");
        for (int i=0; i<board.size(); i++) {
            for (int j=0; j<board.get(0).values.size(); j++) {
                System.out.print(board.get(i).values.get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void turnLeft(Cogwheel cogwheel) {
        List<Integer> numbers = cogwheel.values;
        Integer integer = numbers.remove(0);
        numbers.add(integer);
    }

    private static void turnRight(Cogwheel cogwheel) {
        List<Integer> numbers = cogwheel.values;
        Integer integer = numbers.remove(numbers.size()-1);
        numbers.add(0, integer);
    }

    static class Cogwheel {
        List<Integer> values;
        Integer nextTurn;

        public Cogwheel(List<Integer> values) {
            this.values = values;
            this.nextTurn = null;
        }
    }
}
