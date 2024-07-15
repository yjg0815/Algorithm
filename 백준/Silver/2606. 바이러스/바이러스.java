import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        check = new int[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;

        }

        bfs(1);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        check[start] = 1;
        queue.offer(start);

        int cnt = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < graph.length; i++) {
                if (graph[x][i] == 1 && check[i] != 1) {
                    queue.offer(i);
                    check[i] = 1;
                    cnt ++;
                }
            }

        }

        System.out.println(cnt);

    }

}
