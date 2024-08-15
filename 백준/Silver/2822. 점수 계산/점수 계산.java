import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][2];

        for (int i = 0; i < 8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (int[] a, int[] b)->{
            return b[0]-a[0];
        });
        StringBuilder sb = new StringBuilder();

        int res = 0;
        int[] arrr = new int[5];
        for (int i = 0; i < 5; i++) {
            res += arr[i][0];
            arrr[i] = arr[i][1];
        }
        Arrays.sort(arrr);
        System.out.println(res);
        for (int i = 0; i < 5; i++) {
            sb.append(arrr[i]).append(" ");
        }
        System.out.println(sb);
    }
}