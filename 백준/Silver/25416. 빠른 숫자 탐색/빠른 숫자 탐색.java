import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int r;
    static int c;
    static Deque<Integer[]> queue;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] check;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];
        check = new boolean[5][5];
        res = -1;

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        bfs(r, c);
        System.out.println(res);


    }

    static void bfs(int x, int y) {

        queue = new ArrayDeque<>();
        queue.add(new Integer[] {x, y, 0});
        check[x][y] = true;

        while (!queue.isEmpty()) {
            Integer[] now = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) {
                    continue;
                }

                if (!check[nx][ny] && arr[nx][ny] != -1) {
                    if (arr[nx][ny] == 1) {
                        res = now[2] + 1;
                        break;
                    }
                    queue.add(new Integer[]{nx, ny, now[2] + 1});
                    check[nx][ny] = true;
                }

            }
            if (res != -1) {
                break;
            }
        }

    }
}