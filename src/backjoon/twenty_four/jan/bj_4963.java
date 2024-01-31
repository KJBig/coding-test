package backjoon.twenty_four.jan;

import java.io.*;
import java.util.*;

public class bj_4963 {

    private static int[][] edge;
    private static int[][] visited;
    private static int[] xx = {-1,0,1,1,1,0,-1,-1};
    private static int[] yy = {1,1,1,0,-1,-1,-1,0};
    private static int W;
    private static int H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input = br.readLine().split(" ");
            int result = 0;
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);
            if(W == 0 && H == 0){
                break;
            }
            visited = new int[H][W];
            edge = new int[H][W];
            for(int i=0; i<H; i++){
                String[] split = br.readLine().split(" ");
                for(int j=0; j<split.length; j++){
                    edge[i][j] = Integer.parseInt(split[j]);
                }
            }
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(visited[i][j] == 0 && edge[i][j] == 1) {
                        visited[i][j] = 1;
                        bfs(j, i);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static void bfs(int x, int y){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(x, y));
        while(!queue.isEmpty()){
            List<Integer> poll = queue.poll();
            int px = poll.get(0);
            int py = poll.get(1);

            for(int i=0; i<8; i++){
                int tx = px+xx[i];
                int ty = py+yy[i];
                if(tx>=0 && tx<W && ty>=0 && ty<H) {
                    if (visited[ty][tx] == 0 && edge[ty][tx] == 1) {
                        queue.offer(List.of(tx, ty));
                        visited[ty][tx] = 1;
                    }
                }
            }
        }
    }
}
