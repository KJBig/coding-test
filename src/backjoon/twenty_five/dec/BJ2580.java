package backjoon.twenty_five.dec;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2580 {

    static int[][] SDOKU = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                SDOKU[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
    }

    public static void solution(int row, int col){
        if(col == 9){
            solution(row+1, 0);
            return;
        }

        if(row == 9){
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(SDOKU[i][j]).append(' ');
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }


        if(SDOKU[row][col] == 0){
            for(int i=1; i<=9; i++){
                if(checkSameNum(row, col, i)){
                    SDOKU[row][col] = i;
                    solution(row, col+1);
                }
            }
            SDOKU[row][col] = 0;
            return;
        }

        solution(row, col+1);
    }

    public static boolean checkSameNum(int row, int col, int num){
        for(int i=0; i<9; i++){
            if(SDOKU[row][i] == num){
                return false;
            }
        }

        for(int i=0; i<9; i++) {
            if (SDOKU[i][col] == num) {
                return false;
            }
        }

        int rowLocation = (row/3)*3;
        int colLocation = (col/3)*3;

        for(int i=rowLocation; i<rowLocation+3; i++){
            for(int j=colLocation; j<colLocation+3; j++){
                if(SDOKU[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
