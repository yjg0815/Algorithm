import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 순서대로 한 장씩
        // 사용한 카드 다시 사용x
        // 사용안하고 넘기기 x
        // 카드 뭉치 단어 순서 못바꿈
        // 카드 뭉치 1~10 크기, 각 단어도 1~10
        // 결과는 2~ 20, 각 단어는 1~10
        // 소문자
        
        String answer = "Yes";
        boolean flag = false;
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0; i<goal.length; i++){
            
            if(cards1.length > idx1){
                if(goal[i].equals(cards1[idx1])){
                    idx1 ++;
                    continue;
                }else{
                    answer = "No";
                }
            }
            
            if(cards2.length > idx2){
                if(goal[i].equals(cards2[idx2])){
                    answer = "Yes";
                    idx2 ++;
                }else{
                    answer = "No";
                    break;
                }
            }    
            
        }
        
        return answer;
    }
}