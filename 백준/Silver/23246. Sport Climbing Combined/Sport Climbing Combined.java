import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][1] = a*b*c;
            arr[i][2] = a+b+c;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o2[2], o1[2]);
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(arr[n-i-1][0]).append(" ");
        }
        System.out.println(sb);
    }
}