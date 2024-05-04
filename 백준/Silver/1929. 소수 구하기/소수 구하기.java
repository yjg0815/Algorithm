import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /*
        소수 구하기
        1. n 부터 m 까지 for문 돌면서 다 나눠보기 => 시간초과
        2. n 부터 m 까지 for문 돌되, 소수 체크는 자신의 제곱근까지만

         */
        boolean isTrue = false;
        if (n <= 2) {
            sb.append(2).append("\n");
        }

        for (int i = n; i < m + 1; i++) {
            for (int j = 2; j < sqrt(i) +1; j++) {
                if (i != j) {
                    if (i % j == 0) {
                        isTrue = false;
                        break;
                    } else {
                        isTrue = true;
                    }
                }
            }
            if(isTrue) sb.append(i).append("\n");
        }
        System.out.println(sb);


    }

}

