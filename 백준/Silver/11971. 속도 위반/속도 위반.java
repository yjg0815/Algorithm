import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] cut = new int[101];
        int[] me = new int[101];

        int tmpp = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int road = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = tmpp + 1; j < tmpp + road + 1; j++) {
                cut[j] = speed;
                //System.out.println(j + " " +cut[j]);
            }
            tmpp += road;
        }
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int road = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = tmp + 1; j < tmp + road + 1; j++) {
                me[j] = speed;
                //System.out.println(j + " " +me[j]);
            }
            tmp += road;
        }

        int check = 0;
        for (int i = 0; i < 101; i++) {
            if (me[i] - cut[i] > check) {
                check = me[i] - cut[i];
            }
        }
        System.out.println(check);



    }

}