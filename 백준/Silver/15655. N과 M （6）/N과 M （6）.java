import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static int[] stack;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        stack = new int[m];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int s : stack) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                stack[depth] = arr[i];
                dfs(depth + 1, i);
                check[i] = false;
            }
        }

    }

}