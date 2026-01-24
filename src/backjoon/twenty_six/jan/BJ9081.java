package backjoon.twenty_six.jan;

import java.io.*;

public class BJ9081 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            char[] wordInput = br.readLine().toCharArray();

            if (nextPermutation(wordInput)) {
                sb.append(wordInput).append('\n');
            } else {
                sb.append(wordInput).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static boolean nextPermutation(char[] wordInput) {
        int n = wordInput.length;

        int i = n-2;
        while (i >= 0 && wordInput[i] >= wordInput[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = n-1;
        while (wordInput[i] >= wordInput[j]) {
            j--;
        }

        swap(wordInput, i, j);
        reverse(wordInput, i+1, n-1);

        return true;
    }

    private static void swap(char[] wordInput, int i, int j) {
        char temp = wordInput[i];
        wordInput[i] = wordInput[j];
        wordInput[j] = temp;
    }

    private static void reverse(char[] wordInput, int l, int r) {
        while (l < r) {
            swap(wordInput, l++, r--);
        }
    }
}
