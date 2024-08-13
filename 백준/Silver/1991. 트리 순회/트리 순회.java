import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static String[][] arr;
    static HashMap<String, Integer> alpha;
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][2];
        alpha = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            alpha.put(root, i);
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        sb = new StringBuilder();
        preorder("A");
        System.out.println(sb);
        sb = new StringBuilder();
        inorder("A");
        System.out.println(sb);
        sb = new StringBuilder();
        postorder("A");
        System.out.println(sb);

    }

    static void preorder(String root) {
        sb.append(root);
        int index = alpha.get(root);
        if (!arr[index][0].equals(".")) {
            preorder(arr[index][0]);
        }
        if (!arr[index][1].equals(".")) {
            preorder(arr[index][1]);
        }
    }

    static void inorder(String root) {
        int index = alpha.get(root);
        if (!arr[index][0].equals(".")) {
            inorder(arr[index][0]);
        }
        sb.append(root);
        if (!arr[index][1].equals(".")) {
            inorder(arr[index][1]);
        }


    }

    static void postorder(String root) {
        int index = alpha.get(root);
        if (!arr[index][0].equals(".")) {
            postorder(arr[index][0]);
        }
        if (!arr[index][1].equals(".")) {
            postorder(arr[index][1]);
        }
        sb.append(root);



    }
}