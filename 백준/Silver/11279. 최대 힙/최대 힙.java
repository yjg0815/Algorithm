import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }

            } else {
                queue.offer(x);
            }
        }

        System.out.println(sb);

    }

}
