class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        //알아볼 수 없는 번호 0
        // 최고순위, 최저 순위 순서로 배열
        int[] answer = new int[2];
        int res = 6;
        int correct = 0;
        int zero = 0;
        
        for(int i =0; i<6; i++){
            int check = win_nums[i];
            if(lottos[i] == 0){
                zero ++;
            }
            for(int j =0; j<6; j++){
                if(lottos[j] == check){
                    correct ++;
                    break;
                }
            }
        }
        //System.out.println(res+" "+correct+" "+zero);
        if(correct >= 2){
            res -= correct;
            res++;
            if(correct == 6){
                res = 1;
            }
        }
        
        if(res-zero >= 1){
            answer[0] = res-zero;
            answer[1] = res;
        }else{
            answer[0] = 1;
            answer[1] = res;
        }
        
        
        return answer;
    }
}