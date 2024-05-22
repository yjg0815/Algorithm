import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    누적합 개념을 완전 잘못 이해하고 있었음 4X4 행렬일 때
    2,2까지 구하는거면 (1,1)+(1,2)+(1,3)+(1,4)+(2,1)+(2,2) 이렇게 구하는건 줄 알았는데
    그게 아니라 (1,1)+(1,2)+(2,1)+(2,2) 이렇게 구하는거였음 (주어진 행렬 값)
    즉 (2,2) 에서
    가로누적합 : (1,2)  (dp로 계산된 누적합 값, 행렬값 말고)
    세로누적합 : (2,1)
    중복 구간 : (1,1)
    끝 행렬값 : arr(2,2)
    가로누적합 + 세로 누적합 - 중복구간 + 끝 행렬값
    즉
    (arr[1,1]+arr[1,2]) + (arr[1,1]+arr[2,1]) - (arr[1,1) + arr[2,2]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] =Integer.parseInt(st.nextToken());
            }
            arr.add(tmp);
        }

        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr.get(i-1)[j-1];
                //System.out.println(i+" "+j+" "+dp[i][j]);
            }

        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]).append("\n");

        }

        System.out.println(sb);


    }
}
