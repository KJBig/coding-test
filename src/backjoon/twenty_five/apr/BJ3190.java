package backjoon.twenty_five.apr;

import java.util.*;
import java.io.*;

public class BJ3190 {
        static int[][] MAP;
        static List<int[]> SNAKE = new ArrayList<>();
        static int N, K, L;
        static HashMap<Integer, String> HASH = new HashMap<>();
        static int[] DX = { 0, 1, 0, -1 };
        static int[] DY = { 1, 0, -1, 0 };

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());

            MAP = new int[N][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                MAP[a][b] = 1;

            }

            L = Integer.parseInt(br.readLine());

            for (int i = 0; i < L; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                String c = st.nextToken();
                HASH.put(x, c);
            }

            solve();

        }

        public static void solve() {
            int cx = 0, cy = 0;
            int time = 0;
            int d = 0;
            SNAKE.add(new int[] { 0, 0 });

            while (true) {
                time++;

                int nx = cx + DX[d];
                int ny = cy + DY[d];

                if (isFinish(nx, ny))
                    break;

                if (MAP[nx][ny] == 1) {
                    MAP[nx][ny] = 0;
                    SNAKE.add(new int[] { nx, ny });

                } else {
                    SNAKE.add(new int[] { nx, ny });
                    SNAKE.remove(0);
                }

                if (HASH.containsKey(time)) {
                    if (HASH.get(time).equals("D")) {
                        d += 1;
                        if (d == 4)
                            d = 0;
                    } else {
                        d -= 1;
                        if (d == -1)
                            d = 3;
                    }
                }

                cx = nx;
                cy = ny;
            }

            System.out.println(time);
        }

        public static boolean isFinish(int nx, int ny) {
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                return true;
            }

            for (int i = 0; i < SNAKE.size(); i++) {
                int[] t = SNAKE.get(i);
                if (nx == t[0] && ny == t[1])
                    return true;
            }
            return false;
        }


}
