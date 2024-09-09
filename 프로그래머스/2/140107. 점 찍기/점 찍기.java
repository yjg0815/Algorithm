class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long x,y;
        
        for(int i=0; i*k<= d; i++){
            x = i*k;
            long dd = (long)d*d;
            long xx =  (long)x*x;
            y = (long)Math.sqrt(dd-xx);
            answer += (y/k+1);
        }
        
        return answer;
    }
}