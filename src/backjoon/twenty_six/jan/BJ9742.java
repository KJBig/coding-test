package backjoon.twenty_six.jan;

import java.io.*;

public class BJ9742 {

    private static int TOTAL_COUNT, NUMBER;
    private static boolean[] VISITED;
    private static String ANSWER;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            String[] input = line.split(" ");
            String str = input[0];
            NUMBER = Integer.parseInt(input[1]);


            TOTAL_COUNT =0;
            VISITED = new boolean[str.length()];

            dfs(str, 0, new StringBuilder());

            if(TOTAL_COUNT < NUMBER) {
                ANSWER ="No permutation";
            }

            System.out.println(str + " " + NUMBER + " = " + ANSWER);
        }
    }

    private static void dfs(String str, int cnt, StringBuilder stringBuilder){
        if(cnt == str.length()){
            TOTAL_COUNT++;
            if(TOTAL_COUNT == NUMBER) {
                ANSWER = stringBuilder.toString();
            }
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(!VISITED[i]){
                VISITED[i] = true;
                stringBuilder.append(str.charAt(i));
                dfs(str, cnt+1, stringBuilder);
                stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
                VISITED[i] = false;
            }
        }
    }
}
