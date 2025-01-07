package backjoon.twenty_five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger biN = new BigInteger(st.nextToken());
        BigInteger biM = new BigInteger(st.nextToken());


        StringBuilder sb = new StringBuilder();
        sb.append(biN.divide(biM)).append("\n");
        sb.append(biN.remainder(biM)).append("\n");

        System.out.println(sb);
    }
}
