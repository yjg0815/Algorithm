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

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // 길이가 제각각인 k개의 랜선을 모두 같은 길이의 n개의 랜선으로 자르기
        // n개보다 많이 만드는 것도 n개를 만드는거에 포함
        // 같은 길이보다 작은 길이의 랜선은 버려진다.

        int[] lan = new int[k];
        long max = 0;
        for (int i = 0; i < lan.length; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,lan[i]);
        }


        long lanMax = 0;
        // 랜선의 최대 길이 저장 변수

        long count = 0;
        // 랜선의 개수 저장 변수

        long lo = 1;
        long hi = max;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            count = 0;

            for (int i = 0; i < k; i++) {
                count += lan[i] / mid;
            }
//            System.out.println(lo+" "+hi+" ");
//            System.out.println(mid);
//            System.out.println(count);

            if (count < n) {
                hi = mid - 1;
            } else if(count >= n){
                lo = mid + 1;
            }

        }
        lanMax = hi;

            System.out.println(lanMax);
//        System.out.println(count);


    }


}



