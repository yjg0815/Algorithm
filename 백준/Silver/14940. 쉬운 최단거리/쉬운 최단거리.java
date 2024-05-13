
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;	// 정점
    static int M;	// 간선
    static int[][] graph;	// 무방향 그래프
    static boolean[][] visit;	// 방문 여부 체크

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visit = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    x = i;
                    y = j;
                    graph[i][j] = 0;
                }
            }


        }

        bfs(x, y);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    graph[i][j] = -1;
                }
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visit[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }
                q.add(new Node(nx, ny));
                visit[nx][ny] = true;
                graph[nx][ny] = graph[n.x][n.y] + 1;
            }
        }

    }

}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
1. dx, dy 활용 방식 기억하기
2. 처음에 int[] 생성해서 x,y 좌표 만들었는데, Node 클래스 만드는게 깔끔해보인다.
 */

