import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String[] n1Arr = br.readLine().split("");
        String[] n2Arr = br.readLine().split("");

        List<String> res = new ArrayList<>();
        List<String> check = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            res.add(n1Arr[n1 - i - 1]);
            check.add("R");
        }

        for (int i = 0; i < n2; i++) {
            res.add(n2Arr[i]);
            check.add("L");
        }

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            t--;
            for (int i = 0; i < res.size()-1; i++) {
                if (check.get(i).equals("R") && check.get(i + 1).equals("L")) {
                    String tmp = res.get(i);
                    res.set(i, res.get(i + 1));
                    res.set(i + 1, tmp);

                    check.set(i, "L");
                    check.set(i + 1, "R");
                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
        }
        System.out.println(sb);
    }

}
