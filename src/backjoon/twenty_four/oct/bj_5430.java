package backjoon.twenty_four.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class bj_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            boolean flag = false;
            int dest = 1;
            String[] commends = br.readLine().split("");
            List<Integer> numbers = getNumbers(br);

            for (int index=0; index<commends.length; index++) {
                if (commends[index].equals("R")) {
                    dest = dest*-1;
                } else if (commends[index].equals("D")) {
                    if (numbers.size() == 0) {
                        System.out.println("error");
                        flag = true;
                        break;
                    }
                    if (dest == 1) {
                        numbers.remove(0);
                    } else {
                        numbers.remove(numbers.size()-1);
                    }
                }
            }

            if (!flag) {
                printNumber(numbers, dest);
            }
        }

    }

    private static void printNumber(List<Integer> numbers, int dest) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (dest == 1) {
            for (int i=0; i<numbers.size()-1; i++) {
                sb.append(numbers.get(i)).append(",");
            }
            if (numbers.size()>=1) {
                sb.append(numbers.get(numbers.size() - 1));
            }
        } else {
            for (int i=numbers.size()-1; i>0; i--) {
                sb.append(numbers.get(i)).append(",");
            }
            if (numbers.size()>=1) {
                sb.append(numbers.get(0));
            }
        }

        sb.append("]");

        System.out.println(sb);
    }

    private static List<Integer> getNumbers(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().replace("[", "").replace("]", "").split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<N; i++) {
            numbers.add(Integer.parseInt(inputs[i]));
        }
        return numbers;
    }

}
