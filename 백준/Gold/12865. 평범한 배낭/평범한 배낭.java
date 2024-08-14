import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[101][100001];
        int[][] item = new int[n + 1][2];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken()); // 무게
            item[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (j - item[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i][0]] + item[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        System.out.println(dp[n][k]);

    }
}