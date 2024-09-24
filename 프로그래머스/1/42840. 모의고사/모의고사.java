import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 1번 : 12345
        // 2번 : 21232425
        // 3번 : 3311224455
        
        int[] p1 = new int[5];
        p1[0]=1;p1[1]=2;p1[2]=3;p1[3]=4;p1[4]=5;
        
        int[] p2 = new int[8];
        p2[0]=2;p2[1]=1;p2[2]=2;p2[3]=3;p2[4]=2;
        p2[5]=4;p2[6]=2;p2[7]=5;
        
        int[] p3 = new int[10];
        p3[0]=3;p3[1]=3;p3[2]=1;p3[3]=1;p3[4]=2;
        p3[5]=2;p3[6]=4;p3[7]=4;p3[8]=5;p3[9]=5;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
        
        int idx1=0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] ==  p1[idx1]){
                map.put(1, map.getOrDefault(1,0)+1);
            }
            idx1++;
            
            if(idx1 == 5) idx1 = 0;
        }
        
        int idx2=0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] ==  p2[idx2]){
                map.put(2, map.getOrDefault(2,0)+1);
            }
            idx2++;
            
            if(idx2 == 8) idx2 = 0;
        }
        
        int idx3=0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == p3[idx3]){
                map.put(3, map.getOrDefault(3,0)+1);
            }
            idx3++;
            
            if(idx3 == 10) idx3 = 0;
        }
        
        
        
        List<Integer> arr = new ArrayList<>();
        
        int m = 0;
        int p = 0;
        for(int i=1;i<4; i++){
            if(map.get(i) > m){
                m = map.get(i);
                p = i;
            }
        }
        arr.add(p);
        
        for(int i=1;i<4; i++){
            if(i!=p){
                if(map.get(i) == m){
                    arr.add(i);
                }
            }
        }
        
        // System.out.println(map.get(1));
        // System.out.println(map.get(2));
        // System.out.println(map.get(3));
        // System.out.println(arr);
        
       
        int[] answer = {};
        return arr.stream()
            .mapToInt(Integer::intValue).toArray();
    }
}