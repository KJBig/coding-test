package backjoon.twenty_five.sep;

import java.util.*;

class PG_49994 {
    class Solution {

        static final int[] DX = {1, 0, -1, 0};
        static final int[] DY = {0, -1, 0, 1};

        public int solution(String dirs) {
            int x = 0;
            int y = 0;
            Set<String> visited = new HashSet<>();

            for (char c : dirs.toCharArray()) {
                int dir = toDir(c);
                int nx = x + DX[dir];
                int ny = y + DY[dir];

                if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

                String key = edgeKey(x, y, nx, ny);
                visited.add(key);

                x = nx; y = ny;
            }
            return visited.size();
        }

        private int toDir(char c) {
            if (c == 'R') return 0;
            if (c == 'D') return 1;
            if (c == 'L') return 2;
            return 3;
        }

        private String edgeKey(int x1, int y1, int x2, int y2) {
            if (x1 < x2 || (x1 == x2 && y1 <= y2)) {
                return y1 + "," + x1 + "|" + y2 + "," + x2;
            } else {
                return y2 + "," + x2 + "|" + y1 + "," + x1;
            }
        }
    }


}