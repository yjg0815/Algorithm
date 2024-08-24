import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String res = "stay home";
        int check = Integer.MAX_VALUE;

        for (int i = 0; i < h; i++) {
            int p = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < w; j++) {
                int available = Integer.parseInt(st.nextToken());
                if (available >= n) {
                    int cost = p * n;
                    if (cost <= b) {
                        check = Math.min(check, cost);
                    }
                }
            }
        }

        if (check != Integer.MAX_VALUE) {
            System.out.println(check);
        } else {
            System.out.println(res);
        }

    }
}