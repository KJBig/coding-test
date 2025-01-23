package backjoon.twenty_five.jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] nums = new String[n];
            for(int j = 0; j < n; j++) {
                nums[j] = br.readLine();
            }
            Arrays.sort(nums);

            boolean isInclude = true;
            for(int j = 1; j < n; j++) {
                if(nums[j].startsWith(nums[j - 1])) {
                    isInclude = false;
                    break;
                }
            }
            if(isInclude == false) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
