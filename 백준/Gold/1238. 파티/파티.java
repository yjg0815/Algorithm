import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static boolean[][] check;
    static Deque<Integer> queue = new ArrayDeque<>();
    static int x;
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(arr[i], 1000000);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (i != x) {
                res = Math.max(res, arr[i][x] + arr[x][i]);
            }
        }
        System.out.println(res);
    }
}