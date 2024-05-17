
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    try 1) 그냥 for문 돌면서 구간 마다 더해주기 => 시간초과
    try 2) dp 이용해서 일단 다 구하고, 아닌 구간 빼주기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        int[] dp = new int[n];
        int sum = 0;
        dp[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr.get(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == 1) {
                sb.append(dp[end - 1]).append("\n");
            } else {
                sb.append(dp[end - 1] - dp[start - 2]).append("\n");
            }

        }

        System.out.println(sb);


    }
}
