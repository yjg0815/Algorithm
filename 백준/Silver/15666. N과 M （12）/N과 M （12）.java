import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] arr;
    static boolean[] check;
    static int n, m;
    static int[] res;
    static StringBuilder sb;
    static  LinkedHashSet<Integer> arrSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrSet = new LinkedHashSet<>();
        arr = new int[n];
        res = new int[m];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        sb = new StringBuilder();
        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {

        if (depth >= m) {
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (tmp != arr[i]) {
                if (depth == 0) {
                    res[depth] = arr[i];
                    tmp = arr[i];
                    dfs(depth + 1);
                } else {
                    if (res[depth - 1] <= arr[i]) {
                        res[depth] = arr[i];
                        tmp = arr[i];
                        dfs(depth + 1);
                    }
                }
            }


        }
    }
}