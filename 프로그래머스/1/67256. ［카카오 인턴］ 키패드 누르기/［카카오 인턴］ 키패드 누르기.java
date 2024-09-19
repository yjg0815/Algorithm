import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        //왼손 엄지 처음 *, 오른손 엄지 처음#
        //상하좌우 이동 가능, 왼쪽 3열은 왼손 오른쪽 3열 오른손, 가운데 4열은 현재 위치에서 더 가까운 엄지, 같으면 오른손잡이, 왼손잡이 따라서
        String answer = "";
        
        int curLeft = -1;
        int curRight = -2;
        
        String[] useHand = new String[10];
        for(int i=0; i<10; i++){
            if(i==0||i==2||i==5||i==8){
                useHand[i] = "";
            }else if(i==1||i==4||i==7){
                useHand[i]="L";
            }else{
                useHand[i]="R";
            }
        }
        
        HashMap<Integer, Integer[]> map = new HashMap<>();
        map.put(1, new Integer[] {0,0});
        map.put(2, new Integer[] {0,1});
        map.put(3, new Integer[] {0,2});
        map.put(4, new Integer[] {1,0});
        map.put(5, new Integer[] {1,1});
        map.put(6, new Integer[] {1,2});
        map.put(7, new Integer[] {2,0});
        map.put(8, new Integer[] {2,1});
        map.put(9, new Integer[] {2,2});
        map.put(0, new Integer[] {3,1});
        map.put(-1, new Integer[] {3,0});
        map.put(-2, new Integer[] {3,2});
        
        
        for(int curNum :  numbers){
            if(useHand[curNum].equals("L")){
                curLeft = curNum;
                answer += "L";
            }else if(useHand[curNum].equals("R")){
                curRight = curNum;
                answer += "R";
            }else{
                int curX = map.get(curNum)[0];
                int curY = map.get(curNum)[1];
                int leftX = map.get(curLeft)[0];
                int leftY = map.get(curLeft)[1];
                int rightX = map.get(curRight)[0];
                int rightY = map.get(curRight)[1];
                
                int disL = Math.abs(leftX-curX) + Math.abs(leftY-curY);
                int disR = Math.abs(rightX-curX) + Math.abs(rightY-curY);
                System.out.println(disL + " " + disR);
            
                if(disL < disR){
                    answer += "L";
                    curLeft = curNum;
                }else if(disR < disL){
                    answer += "R";
                    curRight = curNum;
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        curLeft = curNum;
                    }else {
                        answer += "R";
                        curRight = curNum;
                    }
                }
                
            }
        }
        
        return answer;        
    }
}