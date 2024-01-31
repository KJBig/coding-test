package backjoon.twenty_four.jan;

public class bj_4673 {
    public static void main(String[] args){
        int N = 10000;
        int[] able = new int[N+1];
        int i = 1;

        while(i<=N){
            String[] iStr = String.valueOf(i).split("");
            int num = i;
            for(String s : iStr){
                num += Integer.parseInt(s);
            }
            if(num<=N){
                able[num] = 1;
            }
            i++;
        }

        for(int j=1; j<=N; j++){
            if(able[j] == 0){
                System.out.println(j);
            }
        }

    }
}
