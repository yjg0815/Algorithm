
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    그리디일거라고 판단한 이유
    => 옵션 3가지 중, 현재 위치에 의거해 판단을 내리는거라서..
    => 다시 생각하니까 아닌듯, 그게 최적인지 판단할 수가 없을듯
    디피로 해야될듯

    ... DP 문제라고 판단을 했는데
    백준 알고리즘에는 그래프로 되어있었음
    근데 DP로도 풀 수 있는 문제가 맞긴 함 ( 왔다갔다 규칙이 있다 )
    그래프로도 다시 풀어볼까나
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] dp = new int[k+1];
        if (n >= k) {
            System.out.println(n-k);
            return;
        }
        for (int i = 0; i < n; i++) {
            dp[i] = n - i;
        }
        /*
        1) X+1
        2) X-1
        3) 2*X
         */

        for (int i = n + 1; i < k + 1; i++) {
            int min;
            if (i % 2 == 0) {
                min = dp[i / 2] + 1;
                // 순간이동 해서 지금 위치 올 때 1초 흐름
            } else {
                min = Math.min(dp[(i + 1) / 2], dp[(i - 1) / 2]) + 2;
                // 순간이동 하는 시간 + 앞뒤 이동 시간 ==> + 2
            }
            dp[i] = Math.min(min, dp[i - 1] + 1);
            // 순간이동 해서 왔거나, 혹은 그냥 앞뒤 +로 왔거나
            //System.out.println(i+" " +dp[i]);
        }
        System.out.println(dp[k]);
    }
}
