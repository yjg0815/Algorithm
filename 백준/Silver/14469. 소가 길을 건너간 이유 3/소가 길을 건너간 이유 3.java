import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int sec = arr[0][0] + arr[0][1];

        for (int i = 1; i < n; i++) {
            if (arr[i][0] > sec) {
                sec = arr[i][0] + arr[i][1];
            } else {
                sec += arr[i][1];
            }
        }
        System.out.println(sec);
    }
}