import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        while (t > 0) {
            t--;
            int r=1;
            int n = Integer.parseInt(b.readLine());
            int[] a = new int[n+1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(b.readLine());
                a[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            int c = a[1];
            for (int i = 2; i <= n; i++) {
                if (a[i] < c) {
                    c = a[i];
                    r++;
                }
            }
            System.out.println(r);
        }
    }
}