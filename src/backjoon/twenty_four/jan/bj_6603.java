package backjoon.twenty_four.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class bj_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();

            if(input.equals("0")){
                break;
            }

            List<Integer> inputNumbers = Stream.of(input.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int S = inputNumbers.remove(0);
            dfs(S, inputNumbers, new ArrayList<>(), 0);
            System.out.println();
        }
    }

    private static int dfs(int s, List<Integer> inputNumbers, List<Integer> result, int deep) {
        if(result.size() == 6){
            printResult(result);
            return 0;
        }

        for(int i=deep; i<s; i++){
            result.add(inputNumbers.get(i));
            dfs(s, inputNumbers, result, i+1);
            result.remove(result.size()-1);
        }
        return 0;
    }

    private static void printResult(List<Integer> result) {
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

}
