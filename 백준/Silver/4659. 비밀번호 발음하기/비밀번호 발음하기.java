import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = "";

        while (true){
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();
            if(input.equals("end")) {
                break;
            }else {
                boolean flag = true; // 성공 또는 실패를 출력할 flag
                int aeChx = 0;  //1번 조건
                int arrAeChx = 0; //2번 조건
                int arrNotAeChx = 0; //2번 조건
                char arrChx = 0; //3번 조건
                for (char c: input.toCharArray()) {
                    if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                        aeChx++;
                        arrAeChx++;
                        arrNotAeChx=0;
                    }else {
                        arrAeChx=0;
                        arrNotAeChx++;
                    }

                    if(arrAeChx>2||arrNotAeChx>2&&flag){
                        System.out.println("<"+input+"> is not acceptable.");
                        flag=false;
                        break;
                    }

                    if(c==arrChx&&flag){
                        if (arrChx != 'e' && arrChx != 'o') {
                            System.out.println("<"+input+"> is not acceptable.");
                            flag=false;
                            break;
                        }
                    }
                    arrChx = c;
                }

                if(aeChx==0&&flag){
                    System.out.println("<"+input+"> is not acceptable.");
                    flag=false;
                }

                if(flag){
                    System.out.println("<"+input+"> is acceptable.");
                }
            }
        }

    }

}