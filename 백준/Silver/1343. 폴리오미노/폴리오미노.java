import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String res = "";
        String a = "AAAA";
        String b = "BB";
        s = s.replaceAll("XXXX", a);
        res = s.replaceAll("XX", b);

        if (res.contains("X")) {
            res = "-1";
        }

        System.out.println(res);
    }
}