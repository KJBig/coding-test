package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_17478 {
    static String[] STRINGS = { "\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };

    static String LAST_STRING = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";

    static String ANSWER_STRING = "라고 답변하였지.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        dfs(N, 0);
    }

    private static void dfs(int N, int size) {
        if (size == N) {
            printWithUnderBar(size, STRINGS[0]);
            printWithUnderBar(size, LAST_STRING);
            printWithUnderBar(size, ANSWER_STRING);
            return;
        }
        for (int i=0; i<STRINGS.length; i++) {
            printWithUnderBar(size, STRINGS[i]);
        }
        dfs(N, size+1);
        printWithUnderBar(size, ANSWER_STRING);


    }

    private static void printWithUnderBar(int n, String str) {
        String underBar = "____";

        for (int j=0; j<n; j++) {
            System.out.print(underBar);
        }
        System.out.println(str);
    }
}
