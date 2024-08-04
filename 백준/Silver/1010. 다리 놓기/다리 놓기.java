import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            t--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            dp[1][1] = 1;

            for (int i = 2; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            sb.append(dp[m][n]).append("\n");
        }
        System.out.println(sb);
    }
}