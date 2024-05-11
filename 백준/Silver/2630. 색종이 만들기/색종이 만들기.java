import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] res = new int[2];
        DnC(0, 0, n, res);

        System.out.println(res[0]);
        System.out.println(res[1]);
//        System.out.println(white);
//        System.out.println(blue);
    }

    public static void DnC(int r, int c, int n, int[] res) {
        //System.out.println(r+" "+c+" "+res[0]+" "+res[1]+" "+n);

        if (n == 1) {
            if (arr[r][c] == 0) {
                res[0]++;
            } else {
                res[1]++;
            }
            return ;
        }

        boolean check = true;

        if (arr[r][c] == 0) {
            for (int i = r; i < r + n; i++) {
                for (int j = c; j < c + n; j++) {
                    if (arr[i][j] != 0) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                res[0]++;
                return;
            }

        } else if (arr[r][c] == 1) {
            for (int i = r; i < r + n; i++) {
                for (int j = c; j < c + n; j++) {
                    if (arr[i][j] != 1) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                res[1]++;
                return;
            }
        }

        if (!check) {
            DnC(r, c, n / 2, res);
            DnC(r+n/2, c, n / 2, res);
            DnC(r, c+n/2, n / 2, res);
            DnC(r+n/2, c+n/2, n / 2, res);
        }
    }
}
