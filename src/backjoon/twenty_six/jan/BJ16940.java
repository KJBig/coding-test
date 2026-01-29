package backjoon.twenty_six.jan;

import java.io.*;
import java.util.*;

public class BJ16940 {

    static List<List<Integer>> GRAPH;
    static int[] ORDER;
    static int[] POS;
    static boolean[] VISITED;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        GRAPH = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            GRAPH.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            GRAPH.get(a).add(b);
            GRAPH.get(b).add(a);
        }

        ORDER = new int[N];
        POS = new int[N+1];

        String[] orderInput = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            ORDER[i] = Integer.parseInt(orderInput[i]);
            POS[ORDER[i]] = i;
        }

        if(ORDER[0] != 1) {
            System.out.println(0);
            return;
        }

        for(int i=1; i<=N; i++) {
            GRAPH.get(i).sort(Comparator.comparingInt(x -> POS[x]));
        }

        VISITED = new boolean[N+1];
        int[] bfsResult = bfs(N);

        for(int i=0; i<N; i++) {
            if(bfsResult[i] != ORDER[i]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    private static int[] bfs(int N) {
        int[] result = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();

        int index = 0;
        queue.add(1);
        VISITED[1] = true;

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            result[index] = poll;
            index++;

            for(int next : GRAPH.get(poll)) {
                if(!VISITED[next]) {
                    VISITED[next] = true;
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
