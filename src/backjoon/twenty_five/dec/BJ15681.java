package backjoon.twenty_five.dec;

import java.io.*;
import java.util.*;

public class BJ15681 {
    static int N, R, Q;

    static int[] HEAD, TO, NEXT;
    static int EDGE_CNT = 0;

    static int[] PARENT;
    static int[] SUB_SIZE;

    static int[] CHILD_HEAD, CHILD_TO, CHILD_NEXT;
    static int CHILD_EDGE_CNT = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        HEAD = new int[N+1];
        Arrays.fill(HEAD, -1);

        TO = new int[2 * (N-1)];
        NEXT = new int[2 * (N-1)];

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
            addEdge(v, u);
        }

        PARENT = new int[N+1];
        SUB_SIZE = new int[N+1];

        CHILD_HEAD = new int[N+1];
        Arrays.fill(CHILD_HEAD, -1);
        CHILD_TO = new int[N-1];
        CHILD_NEXT = new int[N-1];

        int[] order = buildRootedTreeIterative(R);

        countSubtreeNodesFromOrder(order);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(SUB_SIZE[u]).append('\n');
        }
        System.out.print(sb);
    }
    static void addEdge(int u, int v) {
        TO[EDGE_CNT] = v;
        NEXT[EDGE_CNT] = HEAD[u];
        HEAD[u] = EDGE_CNT++;
    }

    static void addChild(int p, int c) {
        CHILD_TO[CHILD_EDGE_CNT] = c;
        CHILD_NEXT[CHILD_EDGE_CNT] = CHILD_HEAD[p];
        CHILD_HEAD[p] = CHILD_EDGE_CNT++;
    }


    static int[] buildRootedTreeIterative(int root) {
        int[] order = new int[N];
        int idx = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        PARENT[root] = -1;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            order[idx++] = cur;

            for (int i=HEAD[cur]; i!=-1; i=NEXT[i]) {
                int nxt = TO[i];
                if (nxt == PARENT[cur]) continue;

                PARENT[nxt] = cur;
                addChild(cur, nxt);
                stack.push(nxt);
            }
        }
        return order;
    }

    static void countSubtreeNodesFromOrder(int[] order) {
        for (int i=N-1; i>=0; i--) {
            int cur = order[i];

            int size = 1;
            for (int e=CHILD_HEAD[cur]; e!=-1; e=CHILD_NEXT[e]) {
                int child = CHILD_TO[e];
                size += SUB_SIZE[child];
            }
            SUB_SIZE[cur] = size;
        }
    }
}

