import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < p.length; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);

        int[] time = new int[n];
        time[0] = p[0];
        int sum = time[0];
        for (int i = 1; i < n; i++) {
            //System.out.println(i);
            time[i] = time[i-1] + p[i];
            sum += time[i];
        }

        System.out.println(sum);


    }


}



