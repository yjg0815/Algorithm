import java.util.*;
class Solution {
    boolean solution(String s) {
        // System.out.println(st.length);
        Deque<Character> queue = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()){
            if(ch =='('){
                queue.offer(ch);
            }else if(ch == ')'){
                if(queue.isEmpty() || queue.pollLast() != '('){
                    return false;
                }
            }
        }
        
        return queue.isEmpty();
    }
}