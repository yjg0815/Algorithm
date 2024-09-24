class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String ss = s.toLowerCase();

        int p =0;
        int y = 0;
        
        for(char c : ss.toCharArray()){
            if(c=='p') p++;
            else if(c=='y') y++;
        }
        
        if(p != y){
            answer = false;
        }
        
        return answer;
    }
}