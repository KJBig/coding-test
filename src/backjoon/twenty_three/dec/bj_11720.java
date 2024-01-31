package backjoon.twenty_three.dec;
import java.util.*;

public class bj_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] numbers = scanner.nextLine().split("");
        int result = 0;
        for(int i=0; i<N; i++){
            result += Integer.parseInt(numbers[i]);
        }

        System.out.println(result);
    }
}
