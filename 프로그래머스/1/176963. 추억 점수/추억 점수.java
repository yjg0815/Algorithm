import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        //그리움 점수 모두 합산한게 추억점수
        
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i< name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i =0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                String n = photo[i][j];
                if(map.get(n) != null){
                    answer[i] += map.get(n);
                }
            }
        }
        
        return answer;
    }
}