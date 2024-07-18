import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check;
    static int[] arr;
    static int n;
    static int m;
    static StringBuilder sb;
    static int[] res;
    static Set<int[]> noDuplicate = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        res = new int[m];
        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb);

    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                if (flag != arr[i]) {
                    check[i] = true;
                    res[depth] = arr[i];
                    flag = arr[i];
                    dfs(depth + 1);
                    check[i] = false;
                }
            }
        }

    }

}
