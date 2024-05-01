import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] sen = br.readLine().split("");
            if (sen[0].equals(".")) {
                break;
            } else {
                Stack<String> check = new Stack<>();
                for (int i = 0; i < sen.length; i++) {

                    if (sen[i].equals("(") || sen[i].equals("[")) {
                        check.push(sen[i]);
                    } else if (sen[i].equals(")")) {
                        if (!check.empty()) {
                            if (check.peek().equals("(")) {
                                check.pop();
                            } else {
                                check.push(sen[i]);
                            }
                        } else {
                            check.push(sen[i]);
                        }
                    } else if (sen[i].equals("]")) {
                        if (!check.empty()) {
                            if (check.peek().equals("[")) {
                                check.pop();
                            } else {
                                check.push(sen[i]);
                            }
                        } else {
                            check.push(sen[i]);
                        }
                    }
                }

                if (check.isEmpty()) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }

        }

    }
}