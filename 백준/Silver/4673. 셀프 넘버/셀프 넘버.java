import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] d = new int[10001];

        for (int i = 1; i < 10001; i++) {
            String num = i + "";
            int key = i;
            for (int j = 0; j < num.length(); j++) {
                String[] numArr = num.split("");
                key += Integer.parseInt(numArr[j]);
            }

            if (key < 10001) {
                d[key] = i;
            }
            
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            if (d[i] == 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }

}
