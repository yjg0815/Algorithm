import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;	// 정점
    static int M;	// 간선
    static int count;		// 연결 요소의 개수
    static int[][] graph;	// 무방향 그래프
    static boolean[] visit;	// 방문 여부 체크

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visit[i] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int j=1; j<=N; j++) {
                if(graph[temp][j] == 1 && !visit[j]) {
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        for(int i=1; i<=N; i++) {
            if(!visit[i]) {
                bfs(i);
                count ++;
            }
        }
        System.out.println(count);
    }

}