class Solution {
    public int solution(String s) {
        //첫 글자 x
        // 왼 -> 오 x, x아닌 수 카운트, 같아지는 순간 멈추고 문자열 분리
        //s에서 남은 부분에 대해 이 과정 반복, 없으면 종료, 횟수 다른데 읽을거 없어도 종료
        //분해한 문자열 개수 리턴
        int answer = 0;
        
        char[] arr = s.toCharArray();
        char x = arr[0];
        
        int cNum = 0;
        int nNum = 0;
        
        for(int i =0; i<arr.length; i++){
            if(arr[i] == x){
                cNum++;
            }else{
                nNum++;
            }
            
            if(cNum == nNum){
                answer++;
                cNum = 0;
                nNum = 0;
                if(i + 1< arr.length){
                    x = arr[i+1];
                }
            }
        }
        
        if(cNum != nNum){
            answer ++;
        }
        
        return answer;
    }
}