
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            arr.add(tmp);
        }

        arr.sort(
                Comparator.comparingInt((int[] a) -> a[1])
                        .thenComparingInt(a -> a[0])
        ); // 끝나는 시간으로 정렬 후, 같으면 시작하는 시간으로 정렬
        // => 그래야 끝나는 시간 같아도 기존 로직에 맞게 동작함


        int count = 1;
        int check = arr.get(0)[1];

        for (int i = 1; i < n; i++) {
            if (arr.get(i)[0] >= check) {
                count ++;
                check = arr.get(i)[1];
            }
        }

        System.out.println(count);
    }
}
