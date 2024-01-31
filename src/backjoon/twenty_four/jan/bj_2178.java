package backjoon.twenty_four.jan;

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class bj_2178 {
    private static int[] fy = {1, 0, -1, 0};
    private static int[] fx = {0, 1, 0, -1};
    private static List<List<Integer>> BOARD = new ArrayList<>();
    private static int[][] VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         *  1. N, M 입력
         *  2. 미로 입력
         *  BFS로 주변이 1이라면 현재 숫자 +1 반영
         */
        String[] boardSizeInput = br.readLine().split(" ");
        int N = Integer.parseInt(boardSizeInput[0]);
        int M = Integer.parseInt(boardSizeInput[1]);
        for(int i=0; i<N; i++){
            List<Integer> row = Arrays.stream(br.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            BOARD.add(row);
        }
        VISITED = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(BOARD.get(i).get(j) == 1 && VISITED[i][j] == 0) {
                    bfs(i, j, N, M);
                }
            }
        }
        System.out.println(BOARD.get(N-1).get(M-1));
    }

    public static void bfs(int y, int x, int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int pollY = poll[0];
            int pollX = poll[1];

            for(int i=0; i<4; i++){
                int targetY = pollY + fy[i];
                int targetX = pollX + fx[i];
                if(targetX>=0 && targetX<M && targetY>=0 && targetY<N) {
                    if (BOARD.get(targetY).get(targetX) == 1 && VISITED[targetY][targetX] == 0) {
                        queue.add(new int[]{targetY, targetX});
                        VISITED[targetY][targetX] = 1;
                        BOARD.get(targetY).set(targetX, BOARD.get(pollY).get(pollX) + 1);
                    }
                }
            }
        }
    }
}
