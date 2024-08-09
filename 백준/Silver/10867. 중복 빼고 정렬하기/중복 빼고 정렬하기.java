import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        HashSet<Integer> res = new LinkedHashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.add(arr[i]);
        }
        for (Integer a : res) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);

    }
}