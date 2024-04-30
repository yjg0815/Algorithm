import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            int tmp = i;
            while (tmp % 5 == 0) {
                count ++;
                tmp /= 5;
            }
        }
        System.out.println(count);
    }
}
/*
1. 단순히 factorial 값 구해서 돌렸다가, overflow 발생.
=> overflow 날거 같아서 long으로 했는데 그 수준이 아니었던... 무한으로 간다. 숫자 개념이 부족한듯 ㅋ

2. 아 5*2에 0이 생기니까 반복문 돌면서 +5 일때 ++ 해주자
=> 5로 나누어 떨어지면서 또 5로 나누어지고 그렇게 중첩으로 0 붙는 경우를 빼먹음

3. 5 모듈러 연산 활용
*/