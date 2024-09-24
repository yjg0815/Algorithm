import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = n+"";
        Character[] arr = new Character[s.length()];
        for(int i = 0; i<s.length(); i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(Character c : arr){
            sb.append(c);
        }
        return Long.parseLong(sb.toString());
    }
}