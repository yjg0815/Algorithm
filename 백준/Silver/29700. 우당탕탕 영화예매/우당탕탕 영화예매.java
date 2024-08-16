import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m+1];
        int cnt = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr[i][j - 1] == 0) {
                    if (arr[i][j] == 0) {
                        cnt++;
                    } else {
                        cnt = 0;
                    }
                }else{
                    if (arr[i][j] == 0) {
                        cnt ++;
                    }
                }
                if (cnt == k) {
                    res++;
                    cnt--;
                }
            }
            cnt = 0;
        }

        System.out.println(res);
    }
}