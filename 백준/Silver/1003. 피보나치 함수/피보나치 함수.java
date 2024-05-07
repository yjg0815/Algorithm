import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    public static Set<Integer> arr = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] fibo = new int[n+1][2];

            if (n == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            } else if (n == 1) {
                sb.append(0).append(" ").append(1).append("\n");
            } else {
                fibo[0][0] = 1;
                fibo[0][1] = 0;

                fibo[1][0] = 0;
                fibo[1][1] = 1;
                for (int j = 2; j < n+1; j++) {
                    fibo[j][0] = fibo[j-2][0] + fibo[j-1][0];
                    fibo[j][1] = fibo[j-2][1] + fibo[j-1][1];
                }
                sb.append(fibo[n][0]).append(" ").append(fibo[n][1]).append("\n");
            }

        }
        System.out.println(sb);

    }


}