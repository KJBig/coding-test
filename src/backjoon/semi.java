package backjoon;

import java.util.Scanner;

public class semi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");

        System.out.println(Integer.parseInt(split[0]) - Integer.parseInt(split[1]));
    }
}
