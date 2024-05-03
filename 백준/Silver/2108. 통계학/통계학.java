import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int sum = 0;

        int[] count = new int[8001];
        int max = 0;
        int mode = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;
            // 들어온 수가 몇번 카운팅 됐는지 체크할 배열
            // 음수를 고려하여 + 4000 처리 해줌 (절댓값 4000이 최대)
        }

        Arrays.sort(arr);

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                mode = i - 4000;
                max = count[i];
                flag = true;
            } else if (count[i] == max && flag) {
                mode = i - 4000;
                flag = false;
            }
        }

        System.out.println(Math.round((double)sum/n));
        System.out.println(arr[n / 2]);
        System.out.println(mode);
        System.out.println(arr[n-1] - arr[0]);
    }

}
/*
1. 시간초과 고려 => O(n)으로 끝낼 수 있게 최대한 내장함수/동적할당/정렬 자제
2. 최빈값에서 두번째로 작은 값 출력
=> 늘 경험적으로 느끼는거지만, 정확히 어떤 알고리즘이다라고 파악 되지 않는 이상
온갖 이상한 잡기술 붙이는 것 보다, 브루트포스로 for문 돌리는게 가장 빠른 것 같다..
=> 난 늘 for문 쓰는 기본 로직을 두려워하는면이 있는데........
그냥 정석대로 가는 것도 연습을 계속 해야 할 것 같다. 맨날 리스트 겟 셋 할줄이나 알지 배열 기초도 없는 바보.......

 */

