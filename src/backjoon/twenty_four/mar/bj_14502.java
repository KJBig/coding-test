package backjoon.twenty_four.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1. 벽 세우기
2. 바이러스 퍼트리기
3. 0인수 카운트
 */
public class bj_14502 {
    static int[] MX = new int[]{0, 1, 0, -1};
    static int[] MY = new int[]{1, 0, -1, 0};
    static int N;
    static int M;
    static int[][] BOARD;
    static int MAX_NUM = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        BOARD = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] numbers = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                BOARD[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        buildWall(0);
        System.out.println(MAX_NUM);
    }

    private static int buildWall(int count) {
        if (count == 3) {
            process();
            return 0;
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (BOARD[i][j] == 0) {
                    BOARD[i][j] = 1;
                    buildWall(count+1);
                    BOARD[i][j] = 0;
                }
            }
        }
        return 0;
    }

    private static void process() {
        int[][] copyBoard = getCopyBoard();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (copyBoard[i][j] == 2) {
                    spreadVirus(copyBoard, i, j);
                }
            }
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (copyBoard[i][j] == 0) {
                    copyBoard[i][j] = -1;
                    result += countAlive(copyBoard, i, j);
                }
            }
        }
        MAX_NUM = Math.max(MAX_NUM, result);
    }

    private static void spreadVirus(int[][] copyBoard, int i, int j) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(i, j));

        while (!queue.isEmpty()){
            List<Integer> poll = queue.poll();
            int ny = poll.get(0);
            int nx = poll.get(1);

            for (int k=0; k<4; k++) {
                int ay = ny + MY[k];
                int ax = nx + MX[k];
                if (ay >= 0 && ay < N && ax >= 0 && ax < M ) {
                    if (copyBoard[ay][ax] == 0){
                        copyBoard[ay][ax] = 2;
                        queue.add(List.of(ay, ax));
                    }
                }
            }
        }

    }

    private static int countAlive(int[][] copyBoard, int i, int j) {
        int result = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(i, j));

        while (!queue.isEmpty()){
            result++;
            List<Integer> poll = queue.poll();
            int ny = poll.get(0);
            int nx = poll.get(1);

            for (int k=0; k<4; k++) {
                int ay = ny + MY[k];
                int ax = nx + MX[k];
                if (ay >= 0 && ay < N && ax >= 0 && ax < M ) {
                    if (copyBoard[ay][ax] == 0){
                        copyBoard[ay][ax] = -1;
                        queue.add(List.of(ay, ax));
                    }
                }
            }
        }
        return result;
    }

    private static int[][] getCopyBoard() {
        int[][] copyBoard = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                copyBoard[i][j] = BOARD[i][j];
            }
        }

        return copyBoard;
    }
}
