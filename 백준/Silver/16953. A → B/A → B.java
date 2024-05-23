import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 1;

        while (true) {
            //System.out.println(m);
            if (n == m) {
                break;
            }
            if (n > m) {
                count = -1;
                break;
            }

            if (m % 10 == 1) {
                m = (m-1) / 10;
                count ++;

            } else if (m % 2 == 0) {
                m = m / 2;
                count++;
            } else {
                count = -1;
                break;
            }
        }


        System.out.println(count);

    }

}
