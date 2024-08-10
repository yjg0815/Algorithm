import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static Deque<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        queue = new ArrayDeque<>();
        while (n > 0) {
            n--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String inst = st.nextToken();
            if (inst.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
                continue;
            } else if (inst.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.peekFirst());
                }
            } else if (inst.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.pollFirst());
                }
            } else if (inst.equals("size")) {
                sb.append(queue.size());
            } else if (inst.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else if (inst.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.peekLast());
                }
            }
            if (n != 0) {
                sb.append("\n");
            }

        }
        System.out.println(sb);

    }
}