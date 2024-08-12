import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static Deque<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        int i = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        while (true) {
            if (arr[0] == e && arr[1] == s && arr[2] == m) {
                break;
            }
            i++;
            e++;
            s++;
            m++;

            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
        }

        System.out.println(i);

    }
}