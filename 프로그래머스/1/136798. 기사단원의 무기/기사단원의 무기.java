import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        //기사 번호의 약수 개수에 해당하는 공격력을 가진 무기 구매
        // 제한수치보다 큰 공격력 => 정해진 공격력 무기만 구매 가능
        // 공격력당 1kg 철 필요
        
        int answer = 0;
        int cnt = 0;
        
        for(int i =1; i<=number; i++){
            cnt = 0;
            for(int j=1; j<=Math.sqrt(i); j++){
                if(j*j == i){
                    cnt ++;
                }else if(i % j == 0){
                    cnt += 2;
                }
            }

            if(cnt > limit){
                answer += power;
            }else{
                answer += cnt;
            }
        }
        
        
        
        return answer;
    }
}