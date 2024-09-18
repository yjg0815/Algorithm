import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        //R or T
        // C or F
        // J or M
        // A or N
        // 7개의 선택지, n개의 질문 3 2 1 0 1 2 3
        // 지표가 같으면 사전 순으로 빠른거
        String answer = "";
        HashMap<Integer,Integer> point = new HashMap<>();
        
        point.put(1, 3);
        point.put(2,2);
        point.put(3,1);
        point.put(4,0);
        point.put(5,1);
        point.put(6,2);
        point.put(7,3);
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);

        for(int i=0; i<choices.length; i++){
            char[] tmp = survey[i].toCharArray();
            if(choices[i] < 4){
                map.put(tmp[0], map.get(tmp[0])+point.get(choices[i]));
            }else if(choices[i] > 4){
                map.put(tmp[1], map.get(tmp[1])+point.get(choices[i]));
            }
            
           
        }
        
        if(map.get('R') >= map.get('T')){
            answer += "R";
            System.out.println(map.get('R'));
        }else{
            answer += "T";
        }
        
        if(map.get('C') >= map.get('F')){
            answer += "C";
        }else{
            answer += "F";
        }
        
        if(map.get('J') >= map.get('M')){
            answer += "J";
        }else{
            answer += "M";
        }
        
        if(map.get('A') >= map.get('N')){
            answer += "A";
        }else{
            answer += "N";
        }
        
        return answer;
    }
}