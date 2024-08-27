import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[] number = {	"Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine" };

        ArrayList<String> arr = new ArrayList<>();
        for (int num = m; num <= n; num++) {
            String s = "";

            if(num/10 != 0)
                s = number[num/10] + " ";

            s += number[num%10];
            arr.add(s);
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            String res = arr.get(i).replace(" ", "");
            for (int j = 0; j < number.length; j++)
                res = res.replace(number[j], j + "");

            System.out.print(res + " ");
            if(i%10 == 9)
                System.out.println();
        }

    }
}