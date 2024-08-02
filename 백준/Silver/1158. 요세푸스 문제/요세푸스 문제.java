import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        //System.out.println(queue.pollLast());

        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.addLast(queue.pollFirst());
            }
            if (queue.size() != 1) {
                sb.append(queue.pollFirst()).append(", ");
            } else {
                sb.append(queue.pollFirst());
            }

        }

        sb.append(">");
        System.out.println(sb);
    }
}