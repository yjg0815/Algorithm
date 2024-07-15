import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] check;
    static List<Integer> cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    //static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];
        cnt = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            String[] tmp = br.readLine().split("");;
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = Integer.parseInt(tmp[j-1]);

            }
        }


        int num;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                //count = 0;
                if(graph[i][j] == 1){
                    num = bfs(i, j);
                    cnt.add(num);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt.size()).append("\n");

        Collections.sort(cnt);

        for (int a : cnt) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);

    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        //check[x][y] = true;
        graph[x][y] = 0;
        int cnt = 1;

        while (!queue.isEmpty()) {
            //count ++;
            int[] node = queue.poll();
            int a = node[0];
            int b = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];

                if (nx <= n && nx > 0 && ny <= n && ny > 0 && graph[nx][ny] == 1) {
                    //check[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    graph[nx][ny] = 0;
                    cnt ++;
                }
            }
        }
        return cnt;
    }

}


