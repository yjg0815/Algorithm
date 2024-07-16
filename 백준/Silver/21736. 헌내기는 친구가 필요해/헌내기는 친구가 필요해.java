import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<String[]> map = new ArrayList<>();
    static Boolean[][] check;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new Boolean[n][m];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                check[i][j] = false;
                if (row[j].equals("I")) {
                    x = i;
                    y = j;
                }
            }
            map.add(row);
        }

        bfs(x, y);

    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !check[nx][ny]) {
                    check[nx][ny] = true;
                    if (map.get(nx)[ny].equals("O")) {
                        queue.offer(new int[]{nx, ny});
                    } else if (map.get(nx)[ny].equals("P")) {
                        cnt++;
                        queue.offer(new int[]{nx, ny});
                    }

                }

            }
        }

        if (cnt != 0) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
        }
    }

}
