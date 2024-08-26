import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[20][2];

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[20];

        for (int i = n; i >0; i--) {
            if (arr[i][0] > n - i + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(arr[i][1] + dp[i + arr[i][0]], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);


    }
}