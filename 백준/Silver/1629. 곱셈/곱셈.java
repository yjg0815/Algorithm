import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int c;
    static int a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(DnC(b));
        // a를 b번 곱한다는 것에 있어서 오버플로우 발생
        // => D&C 방식을 이용해서 해결

    }

    public static long DnC(int b) {
        if (b == 0) { // b가 0이면 a^0 = 1
            return 1;
        }
        long dept = DnC(b / 2); // 반씩 쪼개가면서 divide

        dept = dept * dept % c; // 처음 DnC(0) = 1, 그러니까 DnC(1) 1*1%c로 시작

        if (b % 2 == 0) {
            return dept;
            // b가 짝수면, b의 제곱 나머지를 주고
        }
        return a * dept % c;
        // 홀수면 a에 b를 곱한 나머지를 줌

    }
}
// 2147483647 198726497 100987253 반례
// 2 222 41 => 4
// 3 200 241 => 225