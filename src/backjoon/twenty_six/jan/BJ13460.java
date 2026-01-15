package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ13460 {

    static int N, M;
    static char[][] BOARD;
    static boolean[][][][] VISITED;

    static int[] DY = {-1, 1, 0, 0};
    static int[] DX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new char[N][M];

        int rY = 0;
        int rX = 0;
        int bY = 0;
        int bX = 0;

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                BOARD[i][j] = c;

                if (c == 'R') {
                    rY = i;
                    rX = j;
                    BOARD[i][j] = '.';
                } else if (c == 'B') {
                    bY = i;
                    bX = j;
                    BOARD[i][j] = '.';
                }
            }
        }

        int answer = bfs(rY, rX, bY, bX);
        System.out.println(answer);
    }

    private static int bfs(int rY, int rX, int bY, int bX) {
        VISITED = new boolean[N][M][N][M];
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(rY, rX, bY, bX, 0));
        VISITED[rY][rX][bY][bX] = true;

        while (!queue.isEmpty()) {
            State poll = queue.poll();

            if (poll.depth >= 10) {
                continue;
            }

            for (int i=0; i<4; i++) {
                MoveResult red = roll(poll.redY, poll.redX, i);
                MoveResult blue = roll(poll.blueY, poll.blueX, i);

                if (blue.goal) {
                    continue;
                }

                if (red.goal) {
                    return poll.depth + 1;
                }

                if (red.y == blue.y && red.x == blue.x) {
                    if (red.dist > blue.dist) {
                        red.y -= DY[i];
                        red.x -= DX[i];
                    } else {
                        blue.y -= DY[i];
                        blue.x -= DX[i];
                    }
                }

                if (!VISITED[red.y][red.x][blue.y][blue.x]) {
                    VISITED[red.y][red.x][blue.y][blue.x] = true;
                    queue.add(new State(red.y, red.x, blue.y, blue.x, poll.depth + 1));
                }
            }
        }

        return -1;
    }

    private static MoveResult roll(int y, int x, int dir) {
        int dist = 0;
        while (true) {
            int ny = y + DY[dir];
            int nx = x + DX[dir];
            char next = BOARD[ny][nx];

            if (next == '#') {
                break;
            }

            y = ny;
            x = nx;
            dist++;

            if (next == 'O') {
                return new MoveResult(y, x, dist, true);
            }
        }
        return new MoveResult(y, x, dist, false);
    }

    static class State {
        int redY;
        int redX;
        int blueY;
        int blueX;
        int depth;

        public State(int redY, int redX, int blueY, int blueX, int depth) {
            this.redY = redY;
            this.redX = redX;
            this.blueY = blueY;
            this.blueX = blueX;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int y;
        int x;
        int dist;
        boolean goal;

        public MoveResult(int y, int x, int dist, boolean goal) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.goal = goal;
        }
    }
}
