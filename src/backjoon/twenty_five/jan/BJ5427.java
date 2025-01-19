package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ5427 {
    static int W, H, RESULT;
    static int[] DX = {1, 0, -1, 0};
    static int[] DY = {0, -1, 0, 1};
    static char[][] ARR;
    static Queue<int[]> QUEUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            ARR = new char[H][W];
            QUEUE = new LinkedList<>();
            RESULT = 0;

            int x = 0, y = 0;

            for(int i = 0; i < H; i++) {
                String str = br.readLine();
                for(int j = 0; j < W; j++) {
                    ARR[i][j] = str.charAt(j);
                    if(ARR[i][j] == '*'){
                        QUEUE.add(new int[]{i, j});
                    }
                    else if(ARR[i][j] == '@'){
                        x = i;
                        y = j;
                    }
                }
            }
            QUEUE.add(new int[]{x, y});
            sb.append(simulation() ? RESULT : "IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static boolean simulation() {
        while(!QUEUE.isEmpty()){
            RESULT++;
            for(int i = 0, size = QUEUE.size(); i<size; i++){
                int[] now = QUEUE.poll();
                for(int j=0; j<4; j++){
                    int nx = now[0] + DX[j];
                    int ny = now[1] + DY[j];
                    if(ny < 0 || ny >= W || nx < 0 || nx >= H){
                        if(ARR[now[0]][now[1]] == '@'){
                            return true;
                        }
                        continue;
                    }
                    if(ARR[nx][ny] != '.'){continue;}
                    ARR[nx][ny] = ARR[now[0]][now[1]];
                    QUEUE.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
