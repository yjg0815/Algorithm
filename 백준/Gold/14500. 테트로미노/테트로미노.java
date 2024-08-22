import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[][] arr;
    static int[][] check;
    static int n, m, res;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] ++;
                dfs(i, j, 0, arr[i][j]);
                check[i][j] --;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = arr[i][j];
                int min = 1001;
                for (int k = 0; k < 4; k++) {
                    if (i + dx[k] >= 0 && i + dx[k] < n && j + dy[k] >= 0 && j + dy[k] < m) {
                        min = Math.min(min, arr[i + dx[k]][j + dy[k]]);
                        tmp += arr[i + dx[k]][j + dy[k]];
                    } else {
                        min = 0;
                    }

                }
                res = Math.max(res, tmp - min);
            }
        }
        System.out.println(res);

    }

    static void dfs(int x, int y, int depth, int val) {
        if (depth == 3) {
            res = Math.max(res, val);
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (check[nx][ny] != 0) {
                    continue;
                }
                check[nx][ny]++;
                dfs(nx, ny, depth + 1, val + arr[nx][ny]);
                check[nx][ny]--;
            }
        }
    }
}