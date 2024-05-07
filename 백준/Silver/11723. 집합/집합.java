import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    public static Set<Integer> arr = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String inst = st.nextToken();

            if (inst.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                add(x);

            } else if (inst.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                check(x);

            } else if (inst.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                remove(x);

            } else if (inst.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                toggle(x);

            } else if (inst.equals("all")) {
                all();

            } else if (inst.equals("empty")) {
                empty();

            }

        }
        System.out.println(sb);

    }

    public static void add(int x) {
        arr.add(x);
    }

    public static void remove(int x) {
        arr.remove(x);
    }

    public static void check(int x) {
        if(arr.contains(x)) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }

    public static void toggle(int x) {
        if(arr.contains(x)) arr.remove(x);
        else arr.add(x);
    }

    public static void all() {
        empty();
        for (int i = 1; i < 21; i++) {
            arr.add(i);
        }
    }

    public static void empty() {
        arr.clear();
    }


}



