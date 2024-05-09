import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        recur((int)Math.pow(2,n), r, c);
        System.out.println(count);

        //int res = recur(r, c, n);
        //System.out.println(res);
    }

//    public static int recur(int r, int c, int n) {
//        if (n == 0) {
//            return 0;
//        }
//        return 2 * (r % 2) + (c % 2) + 4 * recur((int)r / 2, (int)c / 2, n - 1);
//    }
    /*
    식 찾아서 재귀 돌린,ㄴ.. 어렵다
     */
    public static void recur(int size, int r, int c) {
        if(size == 1)
            return;

        if(r < size/2 && c < size/2) {
            recur(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) {
            count += size * size / 4;
            recur(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2) {
            count += (size * size / 4) * 2;
            recur(size/2, r - size/2, c);
        }
        else {
            count += (size * size / 4) * 3;
            recur(size/2, r - size/2, c - size/2);
        }
        
        /*
        처음에 하고자 했던건 비슷한데, 계속 해결하지 못했던 이유
        => 재귀 값 넘겨줄 때, 사이즈가 작아지면서 r,c의 값을 상대적으로 조절해야 한다고 생각했는데
        어떻게 해야 될지 몰라서/.....................
        => 그렇게 넘겨 주고 나서, 값을 찾을 때 뭘 더해야 할까 고민/....
        근데 결국 2사분면이면 1사분면을 지나야하고, 3사분면이면 1,2사분면을 지나(방문)야한다는걸 생각을 못한듯
        cnt 누적 시킬 생각 안하고 끝 번호부터 시작해서 약간 이분탐색처럼 하려고 하다보니까 좀 꼬임
         */

    }

}