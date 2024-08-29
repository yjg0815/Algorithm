
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        String y = st.nextToken();

        int res = x.length();

        for (int i = 0; i < y.length() - x.length() + 1; i++) {
            int tmp = 0;
            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) != y.charAt(j + i)) {
                    tmp++;
                }
            }
            if (res > tmp) {
                res = tmp;
            }
        }
        System.out.println(res);

    }
}